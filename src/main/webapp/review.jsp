<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отзыв о портале</title>
    <link rel="stylesheet" href="../css/form.css">
</head>
<body>

<div class="form-style-5">
    <h2>Пожалуйста, оставьте ваш отзыв о портале КиноМонстр</h2>
    <form class="sendReviewForm" method="post" action="/sendReview">
        <lable>Укажите номер мобильного телефона, чтобы мы могли связаться с вами
            <input class="input input-field phone" id="phone" type="text" name="phone" placeholder="+7 (___) __ - __ - __">
        </lable>
        <lable for="comment">Длина отзыва должна быть не менее 10 символов
            <textarea class="input input-field comment" name="comment" id="comment"></textarea>
        </lable>
        <input type="submit" value="Отправить отзыв" class="btn">
    </form>
        <div class="button"><a href="index.jsp">Вернуться на главную</a></div>
        <div class="button"><a href="profile.jsp">Личный кабинет</a></div>
</div>


<script>
    let form = document.querySelector('.sendReviewForm'),
        formInputs = document.querySelectorAll('.input-field'),
        inputPhone = document.querySelector('.phone'),
        inputComment = document.querySelector('.comment')

    function validatePhone(phone) {
        let re = /^\d[\d\(\)\ -]{4,14}\d$/
        return re.test(String(phone));
    }

    function validateComment(comment) {
        let re = /^.{5,10}$/
        return re.test(String(comment));
    }

    form.onsubmit = function () {
        let phone = inputPhone.value,
            comment = inputComment.value,
            emptyInputs = Array.from(formInputs).filter(input => input.value === '');

        formInputs.forEach(function (input) {
            if (input.value === '') {
                input.classList.add('error');
            } else {
                input.classList.remove('error');
            }
        });

        if (emptyInputs.length !== 0) {
            return false;
        }

        if (!validatePhone(phone)) {
            phone.classList.add('error');
            return false;
        } else {
            phone.classList.remove('error');
        }

        if (!validateComment(comment)) {
            phone.classList.add('error');
            return false;
        } else {
            phone.classList.remove('error');
        }

    }
</script>

</body>
</html>

