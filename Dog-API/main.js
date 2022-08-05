const breedListEl = document.getElementById("breed-list");


// Lay danh sach giong loai va hien thi
const getBreedList = async () => {
    try {
        let res = await axios.get("https://dog.ceo/api/breeds/list/all");
        
        renderBreedList(res.data.message);
        // renderSubBreedList(res.data.message);
    } catch (error) {
        console.log(error)
    }
}

//render list ra select
const renderBreedList = obj => {
    // console.log(obj);
    let keys = Object.keys(obj)

    console.log(keys);

    let html ="";

    keys.forEach(key => {
        html += `<option value=${key}>${key}</option>`;
    })
    breedListEl.innerHTML = html;
}

const result = document.querySelector('.result')
const btnRandom = document.getElementById("btn")
const imageEl = document.getElementById("image")

btnRandom.addEventListener("click", async () => {
    try {
        subBreedListEl.innerHTML = "";
        result.style.visibility = 'hidden';

        let value = breedListEl.options[breedListEl.selectedIndex].value;
        let response = await axios.get(`https://dog.ceo/api/breed/${value}/list`); // lay danh sach giong loai con
        console.log(response);

        if (response.data.message.length == 0) {
            const para = document.createElement("li");
            para.innerHTML = `Sub breed don't exist`;
            subBreedListEl.appendChild(para);
        } else {
            renderSubBreedList(response.data.message, value);
        }

    } catch (error) {
        console.log(error);
    }
})
const subBreedListEl = document.getElementById("list")

const renderSubBreedList = (obj, value) => {
    let key = Object.values(obj);
    console.log(key);

    key.forEach(key => {
        const para = document.createElement("li");
        para.innerHTML = `${key}`;
        
        subBreedListEl.appendChild(para);
        
        para.addEventListener("click", async () => {
            try {
                let res = await axios.get(`https://dog.ceo/api/breed/${value}/${key}/images/random`);
                imageEl.src = res.data.message;
                result.style.visibility = 'visible';
            } catch (error) {
                console.log(error)
            }
        })
    })
}




getBreedList();





// tao event
// btnRandom.addEventListener("click", async() => {
//     try {
//         let value = breedListEl.options[breedListEl.selectedIndex].value;

//         let response = await axios.get(`https://dog.ceo/api/breed/${value}/images/random`);
//         console.log(response);
//         imageEl.src = response.data.message;    
//     } catch (error) {
//         console.log(error);
//     }

// })