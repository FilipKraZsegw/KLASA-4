<?php require 'db.php'; ?>

<?php
if (!isset($_SESSION['user'])) {
    header("Location: login.php");
    exit();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $imie = $_POST['imie'];
    $nazwisko = $_POST['nazwisko'];
    $email = $_POST['email'];
    $uid = $_SESSION['user_id'];

    $sql = "INSERT INTO uzytkownicy_dane (user_id, imie, nazwisko, email)
            VALUES ($uid, '$imie', '$nazwisko', '$email')";
    mysqli_query($conn, $sql);

    $_SESSION['formularz_wyslany'] = true;

    echo "Dane zapisane!";
}
?>

<h2>Panel użytkownika: <?= $_SESSION['user'] ?></h2>

<form method="post">
    Imię: <input type="text" name="imie"><br>
    Nazwisko: <input type="text" name="nazwisko"><br>
    Email: <input type="email" name="email"><br>
    <button type="submit">Wyślij formularz</button>
</form>

<br>
<a href="logout.php">Wyloguj</a>

<?php if ($_SESSION['role'] == 'admin'): ?>
    <br><a href="wyniki.php">Zobacz wyniki (admin)</a>
<?php endif; ?>