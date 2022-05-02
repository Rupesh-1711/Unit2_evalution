// write js code here corresponding to index.html
// You should add submit event on the form
document.querySelector("#masaiForm").addEventListener("submit",shedule)

var arrInfo = JSON.parse(localStorage.getItem("schedule"))|| []

function shedule(){
   event.preventDefault()

   var  objInfo={

           matchNum:document.querySelector("#matchNum").value,
           teamA:document.querySelector("#teamA").value,
           teamB:document.querySelector("#teamB").value,
           dateTime:document.querySelector("#date").value,
           venue:document.querySelector("#venue").value,
   }
   arrInfo.push(objInfo)

   localStorage.setItem("schedule",JSON.stringify(arrInfo))
}