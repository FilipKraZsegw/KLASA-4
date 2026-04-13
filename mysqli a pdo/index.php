<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
        <<style>
        table{
            border: 1px solid black
        }
        td{
            border: 1px solid black
        }
        tr{
            border: 1px solid black
        }
        </style>
    </head>
    <body>
    
    </body>
</html>

<?php

include 'connect.php';

$conn = new mysqli($host, $user, $pass, $db);

if ($conn->connect_error) {
    die("Błąd połączenia: " . $conn->connect_error);
}

echo 'MySQLi: <br>';

$sql = "SELECT id_mieszkania, metraz, ulica FROM adres WHERE metraz > 100 AND ulica LIKE 'K%' ORDER BY metraz DESC";
$result = $conn->query($sql);

echo '<table>';
if ($result->num_rows > 0) {    while($row = $result->fetch_assoc()) {
        echo "<tr><td> ID:" . $row["id_mieszkania"] . "</td><td> Ul. ".$row["ulica"]. "</td><td>  Metraż: " . $row["metraz"] . " m2 </td></tr>";
    }
} else {
    echo "Brak wyników.";
}
echo '</table>';

$conn->close();

echo '<br><br> PDO: <br>';
try {

    $pdo = new PDO($dsn, $user, $pass);

    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $stmt = $pdo->query("SELECT id_mieszkania, metraz, ulica FROM adres WHERE metraz > 100 AND ulica LIKE 'K%' ORDER BY metraz DESC");
echo '<table>';

    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
        echo "<tr><td> ID:" . $row["id_mieszkania"] . "</td><td> Ul. ".$row["ulica"]. "</td><td>  Metraż: " . $row["metraz"] . " m2 </td></tr>";
    }

} catch (PDOException $e) {
    echo "Błąd bazy danych: " . $e->getMessage();
}
echo '</table>';

?>
    