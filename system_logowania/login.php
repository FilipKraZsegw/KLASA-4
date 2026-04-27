<?php require 'db.php'; ?>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $login = $_POST['login'];
    $haslo = $_POST['haslo'];

    $stmt = $pdo->prepare("SELECT * FROM uzytkownicy WHERE login = ?");
    $stmt->execute([$login]);
    $user = $stmt->fetch();

    if ($user && password_verify($haslo, $user['haslo'])) {
        $_SESSION['user'] = $user['login'];
        $_SESSION['user_id'] = $user['id'];
        $_SESSION['role'] = $user['rola'];
        $_SESSION['formularz_wyslany'] = false;

        $stmt = $pdo->prepare("INSERT INTO logi (user_id, data_logowania, formularz_wyslany)
                               VALUES (?, NOW(), 'nie')");
        $stmt->execute([$user['id']]);

        $_SESSION['log_id'] = $pdo->lastInsertId();

        header("Location: panel.php");
        exit;
    } else {
        echo "Błędny login lub hasło";
    }
}
?>

<form method="post">
    Login: <input type="text" name="login"><br>
    Hasło: <input type="password" name="haslo"><br>
    <button type="submit">Zaloguj</button>
</form>