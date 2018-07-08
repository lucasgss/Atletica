function validaLogin(email,senha){
        msg = ""
        function setarMenssagem(){
            $("#loginInvailidoText").html(msg);
        }
        if (email.trim()==""){
            $("#loginInvalido").show();
            msg = "Favor digitar o email!";
            setarMenssagem();
            return false;
        }
        if (senha.trim()==""){
            $("#loginInvalido").show();
            msg = "Favor dgitar a senha!";
            setarMenssagem();
            return false;
        }

        return true;
}