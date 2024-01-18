function cats(array) {
  

   
    class Cat{
        constructor(name, age){
            this.name = name;
            this.age = age;
        }
        meow(){
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }
    let cats = [];
    for (const iterator of array) {
     let [name, age] = iterator.split(" ");
     cats.push(new Cat(name,age));
    }
    for (const cat of cats) {
       cat.meow();
    }

}
cats(['Mellow 2', 'Tom 5']);