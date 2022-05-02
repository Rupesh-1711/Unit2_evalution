// write js code here corresponding to favourites.html

var addFav = JSON.parse(localStorage.getItem("favourites"))


  display(addFav)

  function display(data)
  {

      data.forEach(function(ele,index){
          var tr = document.createElement("tr")

          var td1 = document.createElement("td")
            td1.innerText = ele.matchNum

          var td2 = document.createElement("td")
              td2.innerText=ele.teamA
          var td3 = document.createElement("td")
          td3.innerText=ele.teamB

          var td4 = document.createElement("td")
          td4.innerText=ele.dateTime

          var td5 = document.createElement("td")
          td5.innerText=ele.venue

          var td6 = document.createElement("td")
          td6.innerText="Delete"
          td6.style.color="red"
          td6.style.cursor="pointer"
          td6.addEventListener("click",function(){
            deleteFun(ele,index)
          })
          tr.append(td1,td2,td3,td4,td5,td6)
          document.querySelector("tbody").append(tr)
      })
     
      function deleteFun(ele,index)
      {
        addFav.splice(index,1)
        localStorage.setItem("favourites",JSON.stringify(addFav))
        window.location.reload()
      }

  }