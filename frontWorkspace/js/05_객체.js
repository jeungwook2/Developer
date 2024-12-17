function f01(){
    const product = {
        price : 3000,
    };
    product["name"] = "galaxy24";
    product["color"] = "black";
    product["camera cnt"] = 4;
    // product.price = 3000;
    product.info = function(){
        console.log("=====info=====");
        
        console.log(this);
        console.log(this.name);
        console.log(this.price);
        console.log(this.color);
    };

    console.log(product);
    console.log(product.name);
    console.log(product.price);
    console.log(product["camera cnt"]);
    
    console.log(product.info);
    product.info();
    
}

// f01();

// const person1 = {};
// person1.nick = "kim";
// person1.hello = function(){
//     console.log("hello~~~ " + this.nick);
// }

// const person2 = {};
// person2.nick = "choi";
// person2.hello = person1.hello;

// person1.hello();
// person2.hello();

function f02(){
    const game= {
        title : "스타크래프트",
        price : 2000,
        service : true,
        os : ["win10", "win11"]
    };
    
    for(const k in game){
        console.log(game[k]);
        
    }
}

// f02();

function f03(){
    const student = {};
    student["name"] = "홍길동";
    student.age = 20;

    delete(student.age)

    console.log(student);
    
}

// f03();

function f04(){
    
    //     function createStudent(a,b){
    //         const obj = {};
    //         obj.name = a;
    //         obj.score = b;
    //         return obj;
    //     }

    //     const s1 = createStudent("홍길동", 100);
    //     console.log(s1);

    //생성자 함수
    function Student(a,b){
        this.name = a;
        this.score = b;
    }

    const s1 = new Student("홍길동", 100);
    const s2 = new Student("김철수", 100);
    
    Student.prototype.hello = function(){
        console.log(`안녕 나는 ${this.name}, 성적은 ${this.score} 이야`);
    }    

    console.log(s1);
    console.log(s2);
    
    s1.hello();
    s2.hello();

    Student.prototype.java = "good";
    console.log(Student.prototype);
    console.log(s1.__proto__);
    console.log(s2.__proto__);

    console.log(s1.__proto__.constructor);
    console.log(Student.prototype.constructor);
    console.log(Student);
    
    
}

f04();