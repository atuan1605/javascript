const grades = [
    { name: 'John', grade: 8, sex: 'M' },
    { name: 'Sarah', grade: 12, sex: 'F' },
    { name: 'Bob', grade: 16, sex: 'M' },
    { name: 'Johnny', grade: 2, sex: 'M' },
    { name: 'Ethan', grade: 4, sex: 'M' },
    { name: 'Paula', grade: 18, sex: 'F' },
    { name: 'Donald', grade: 5, sex: 'M' },
    { name: 'Jennifer', grade: 13, sex: 'F' },
    { name: 'Courtney', grade: 15, sex: 'F' },
    { name: 'Jane', grade: 9, sex: 'F' }
];

//Ex1
function averagePoint(grades) {
    let sum = 0;
    for (let i = 0; i < grades.length; i++) {
        sum += grades[i].grade;
    }

    return 'Point: ' + sum / (grades.length);
}

console.log(averagePoint(grades));

//Ex2
function malePoint(grades) {
    let sum = 0;
    let count = 0;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'M') {
            sum += grades[i].grade;
            count++;
        }
    }
    return 'Point: ' + sum / count;
}
console.log(malePoint(grades));

//Ex3
function femalePoint(grades) {
    let sum = 0;
    let count = 0;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'F') {
            sum += grades[i].grade;
            count++;
        }
    }
    return 'Point: ' + sum / count;
}
console.log(femalePoint(grades));

//Ex4
function maleHighestPoint(grades) {
    let max = 0;
    let maleStudent;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'M') {
            if (max < grades[i].grade) {
                max = grades[i].grade;
                maleStudent = grades[i]
            }
        }
    }
    return maleStudent;
}
console.log("Male's highest point: ")
console.log(maleHighestPoint(grades));

//Ex5
function femaleHighestPoint(grades) {
    let max = 0;
    let femaleStudent;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'F') {
            if (max < grades[i].grade) {
                max = grades[i].grade;
                femaleStudent = grades[i]
            }
        }
    }
    return femaleStudent
}
console.log("Female's highest point: ")
console.log(femaleHighestPoint(grades));


//Ex6
function maleLowestPoint(grades) {
    let min = Number.MAX_VALUE;
    let maleStudent;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'M') {
            if (min > grades[i].grade) {
                min = grades[i].grade;
                maleStudent = grades[i]
            }
        }
    }
    return maleStudent;
}
console.log("Male's lowest point: ")
console.log(maleLowestPoint(grades));

//Ex7
function femaleLowestPoint(grades) {
    let min = Number.MAX_VALUE;
    let maleStudent;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'F') {
            if (min > grades[i].grade) {
                min = grades[i].grade;
                maleStudent = grades[i]
            }
        }
    }
    return maleStudent;
}
console.log("Female's lowest point: ")
console.log(femaleLowestPoint(grades));

//Ex8
function highestPoint(grades) {
    let max = 0;
    let student;
    for (let i = 0; i < grades.length; i++) {
        if (max < grades[i].grade) {
            max = grades[i].grade;
            student = grades[i]
        }
    }
    return student;
}
console.log("Highest point: ")
console.log(highestPoint(grades));

//Ex9
function lowestPoint(grades) {
    let min = Number.MAX_VALUE;
    let student;
    for (let i = 0; i < grades.length; i++) {
        if (min > grades[i].grade) {
            min = grades[i].grade;
            student = grades[i];
        }
    }
    return student;
}
console.log("Lowest point: ")
console.log(lowestPoint(grades));

//Ex10
function getFemale(grades) {
    let student = [];
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'F') {
            student.push(grades[i]);
        }
    }
    return student;
}
console.log('List female: ')
console.log(getFemale(grades));

//Ex11
function sortByName(grades) {
    grades.sort(function (o1, o2) {
        if (o1.name < o2.name) return -1;
        if (o1.name > o2.name) return 1;
        return 0;
    })
    return grades;
}
console.log('Sort by name:');
console.log(sortByName(grades));

//Ex12
function getListFemaleJ(grades) {
    let arr = [];
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == 'F' && grades[i].name.charAt(0) == 'J'){
            arr.push(grades[i]);
        }
    }
    return arr;
}
console.log('List female: ')
console.log(getListFemaleJ(grades));

//Ex13
function getListTop5(grades){
    grades.sort(function(o1,o2){
        return o2.grade - o1.grade;
    })
    let arr = [];
    let i = 0;
    while(i < 5){
        arr.push(grades[i]);
        i++;
    }

    return arr;
}
console.log('Top 5: ')
console.log(getListTop5(grades));

