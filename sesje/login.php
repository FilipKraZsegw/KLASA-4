<?php require 'db.php'; ?>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $login = $_POST['login'];
    $haslo = $_POST['haslo'];

    $sql = "SELECT * FROM uzytkownicy WHERE login='$login'";
    $result = mysqli_query($conn, $sql);
    $user = mysqli_fetch_assoc($result);

    if ($user && password_verify($haslo, $user['haslo'])) {

        $_SESSION['user'] = $user['login'];
        $_SESSION['role'] = $user['rola'];
        $_SESSION['user_id'] = $user['id'];
        $_SESSION['formularz_wyslany'] = false;

        $uid = $user['id'];
        mysqli_query($conn, "
            INSERT INTO logi (user_id, data_logowania, formularz_wyslany)
            VALUES ($uid, NOW(), 'nie')
        ");

        $_SESSION['log_id'] = mysqli_insert_id($conn);

        header("Location: panel.php");
        exit();
    } else {
        echo "Błędne dane logowania!";
    }
}
?>

<form method="post">
    Login: <input type="text" name="login"><br>
    Hasło: <input type="password" name="haslo"><br>
    <button type="submit">Zaloguj</button>
</form>