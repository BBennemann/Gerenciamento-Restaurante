const iname = document.getElementById("username")
const iemail = document.getElementById("email")
const ipassword = document.getElementById("password")
const iphone = document.getElementById("telefone")
const buttonCadastro = document.getElementById("button-cadastro")
const buttonLogin = document.getElementById("button-login")


fetch('http://localhost:3000/usuarios')
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
    return response.json(); // Parse JSON response
  })
  .then(data => {
    console.log(data); // Handle the data
    buttonLogin.addEventListener("click", () => {
      logar(data, iname.value , ipassword.value)
    })

  })
  .catch(error => {
    console.error('Error fetching data:', error);
  });


function cadastrar() {
  fetch("http://localhost:3000/usuarios", 
    {
      headers: {
        "Accept": "application/json",
        "content-Type": "application/json"
      },
      method: "POST",
      body: JSON.stringify({
        nome: iname.value,
        email: iemail.value,
        senha: ipassword.value,
        telefone: iphone.value
      })
    }) .then(() => {
      alert("Cadastrado com sucesso!");
    }).catch(() => {
      alert("Erro ao cadastrar!");
    })
}


buttonCadastro.addEventListener("click", () => {
  cadastrar()
})