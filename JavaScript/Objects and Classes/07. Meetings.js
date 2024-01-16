function meetings(array) {
    let meetingList = {};
    for (let iterator of array) {
        let [day, name] = iterator.split(" ");
     
        if(meetingList.hasOwnProperty(day)){
            console.log(`Conflict on ${day}!`);
        }else{
            meetingList[day] = name;
            console.log(`Scheduled for ${day}`);
        }
        
    }
    for (const key in meetingList) {
        console.log(`${key} -> ${meetingList[key]}`);
            
       
    }
}
meetings(['Friday Bob', 'Saturday Ted', 'Monday Bill',
'Monday John', 'Wednesday George']);