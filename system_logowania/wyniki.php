<?php require 'db.php'; ?>

<?php
if (!isset($_SESSION['user']) || $_SESSION['role'] !== 'admin') {
    header("Location: login.php");
    exit;
}

$stmt = $pdo->query("
    SELECT u.login, d.imie, d.nazwisko, d.email, d.data_dodania
    FROM uzytkownicy_dane d
    JOIN uzytkownicy u ON d.user_id = u.id
");
?>

<h2>Dane użytkowników</h2>

<table border="1" cellpadding="8">
<tr>
    <th>Login</th><th>Imię</th><th>Nazwisko</th><th>Email</th><th>Data</th>
</tr>

<?php while ($row = $stmt->fetch()): ?>
<tr>
    <td><?= $row['login'] ?></td>
    <td><?= $row['imie'] ?></td>
    <td><?= $row['nazwisko'] ?></td>
    <td><?= $row['email'] ?></td>
    <td><?= $row['data_dodania'] ?></td>
</tr>
<?php endwhile; ?>

</table>