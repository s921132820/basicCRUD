$(document).ready(function() {
    $("form").on("submit", function() {

        if($("#name").val().length == 0) {
            event.preventDefault()
            alert("이름은 필수입니다.")
            $("#name").focus()
            return;
        }
        if($("#age").val().length == 0) {
            event.preventDefault()
            alert("나이는 필수입니다.")
            $("#age").focus()
            return;
        }
        if($("#address").val().length == 0) {
            event.preventDefault()
            alert("주소는 필수입니다.")
            $("#address").focus()
            return;
        }
    })
})