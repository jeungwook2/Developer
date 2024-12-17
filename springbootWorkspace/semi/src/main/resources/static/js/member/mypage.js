    const editbtn = document.querySelector("#edit-form input[type=button]");

    editbtn.addEventListener('click',(evt)=>{
        const id = document.querySelector("#edit-form input[name=id]");
        const nick = document.querySelector("#edit-form input[name=nick]");

        id.removeAttribute("disabled");
        nick.removeAttribute("disabled");

        editbtn.remove();

        const submitButton = document.createElement("input");

            
            submitButton.setAttribute("type", "submit");
            submitButton.setAttribute("value", "등록");

        const form = document.querySelector("#edit-form");
        form.appendChild(submitButton);
    })