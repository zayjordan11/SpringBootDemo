let favCandyButton = document.getElementById("fav_candy_button");

favCandyButton.addEventListener('click', async() => {

//Fetch
    
    try{
    
        const raw_response = await fetch(`http://localhost:8080/app/candies`); 
    
    if(!raw_response.ok){
        throw new Error(raw_response.status)
    }
    
    const json_data = await raw_response.json();
    
    console.log(json_data);

    var input =document.getElementById("input");

    input.innerText = `My favorite candy is ${json_data[0].name}, you can get this candy from ${json_data[0].shop.shopName} for ${json_data[0].price} each.`;
    
    }catch(error){
    console.log(error)
    }
    
    });