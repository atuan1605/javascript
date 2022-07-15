let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
];

let boxes = document.querySelector('.boxes');

function createBox(count) {
    for (let i = 0; i < count; i++) {
        let newBox = document.createElement('div');
        boxes.appendChild(newBox);
        newBox.classList.add("box");
        newBox.style.backgroundColor = setColor(colors);
        newBox.addEventListener('click', () => {
            newBox.parentNode.removeChild(newBox);
            point.innerHTML = parseInt(point.innerHTML, 10) -1;
        })
    }
}


function setColor(color) {
    let index = Math.floor(Math.random() * color.length);
    this.color = color[index];
    return this.color;
}

let clicked = document.getElementById("btn");

let point = document.querySelector('.points');
point.innerHTML = '5';

let count = parseInt(point.innerHTML, 10);
createBox(count);
clicked.addEventListener('click', () => {
    point.innerHTML = parseInt(point.innerHTML, 10) + 5;
    createBox(count);
});
