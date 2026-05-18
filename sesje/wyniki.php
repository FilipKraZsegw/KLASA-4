<?php require 'db.php'; ?>

<?php
if (!isset($_SESSION['user']) || $_SESSION['role'] != 'admin') {
    header("Location: login.php");
    exit();
}

$sql = "SELECT u.login, d.imie, d.nazwisko, d.email, d.data_dodania
        FROM uzytkownicy_dane d
        JOIN uzytkownicy u ON d.user_id = u.id";

$result = mysqli_query($conn, $sql);

echo "<h2>Dane użytkowników</h2>";
echo "<table border='1' cellpadding='8'>";
echo "<tr><th>Login</th><th>Imię</th><th>Nazwisko</th><th>Email</th><th>Data</th></tr>";

while($row = mysqli_fetch_assoc($result)) {
    echo "<tr>
            <td>{$row['login']}</td>
            <td>{$row['imie']}</td>
            <td>{$row['nazwisko']}</td>
            <td>{$row['email']}</td>
            <td>{$row['data_dodania']}</td>
          </tr>";
}

echo "</table>";