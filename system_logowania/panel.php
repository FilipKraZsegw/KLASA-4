<?php require 'db.php'; ?>

<?php
if (!isset($_SESSION['user'])) {
    header("Location: login.php");
    exit;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $imie = $_POST['imie'];
    $nazwisko = $_POST['nazwisko'];
    $email = $_POST['email'];

    $stmt = $pdo->prepare("INSERT INTO uzytkownicy_dane (user_id, imie, nazwisko, email)
                           VALUES (?, ?, ?, ?)");
    $stmt->execute([$_SESSION['user_id'], $imie, $nazwisko, $email]);

    $_SESSION['formularz_wyslany'] = true;

    echo "Dane zapisane!";
}
?>

<h2>Witaj <?= $_SESSION['user'] ?></h2>

<?php if (isset($_SESSION['user']) && $_SESSION['role'] === 'admin'): ?>
    <p>
        <a href="wyniki.php">Przejdź do podglądu wyników</a>
    </p>
<?php endif; ?>

<form method="post">
    Imię: <input type="text" name="imie"><br>
    Nazwisko: <input type="text" name="nazwisko"><br>
    Email: <input type="email" name="email"><br>
    <button type="submit">Wyślij</button>
</form>

<a href="logout.php">Wyloguj</a>