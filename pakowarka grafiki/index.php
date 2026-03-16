<?php

if (!isset($_FILES['obrazy'])) {
    die("Nie przesłano zdjęć.");
}

$allowed = ['jpg', 'jpeg', 'png'];

$zipName = "folder_" . time() . ".zip";

$zip = new ZipArchive();

if ($zip->open($zipName, ZipArchive::CREATE) !== TRUE) {
    die("Nie można utworzyć archiwum ZIP.");
}

foreach ($_FILES['obrazy']['tmp_name'] as $key => $tmp_name) {

    $originalName = $_FILES['obrazy']['name'][$key];

    $extension = strtolower(pathinfo($originalName, PATHINFO_EXTENSION));

    if (!in_array($extension, $allowed)) {
        continue;
    }

    $zip->addFile($tmp_name, $originalName);
}

$zip->close();

echo "<h2>Pliki zapakowane!</h2>";
echo "<a href='$zipName' download>Pobierz plik ZIP</a>";
?>