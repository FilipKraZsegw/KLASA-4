<head>
    <link rel="stylesheet" href="style.css">
    <title>Formularz</title>
</head>
<?php

session_start();

$db = mysqli_connect('localhost','root','','zadania');

$imie = $_POST['imie'];
$nazwisko = $_POST['nazwisko'];
$ulica = $_POST['ulica'];
$nr_mieszkania = $_POST['nr_mieszkania'];
$miasto = $_POST['miasto'];
$kod_pocztowy = $_POST['kod_pocztowy'];
$telefon = $_POST['telefon'];

$regex_kod_pocztowy = '/^[0-9]{2}-[0-9]{3}$/';
$regex_telefon = '/^\+[0-9]{2} [0-9]{3} [0-9]{3} [0-9]{3}$/';

if(preg_match($regex_kod_pocztowy, $kod_pocztowy)){
    if(preg_match($regex_telefon, $telefon)){
        if($nr_mieszkania == NULL){
            $p = "INSERT INTO formularz (imie, nazwisko, ulica, miasto, kod_pocztowy, telefon) VALUES ('$imie', '$nazwisko', '$ulica', '$miasto', '$kod_pocztowy', '$telefon')";
            $wynik = mysqli_query($db, $p);
        echo "<h2>Rejestracja zakończona sukcesem";
        }else{
            $p = "INSERT INTO formularz (imie, nazwisko, ulica, nr_mieszkania , miasto, kod_pocztowy, telefon) VALUES ('$imie', '$nazwisko', '$ulica', '$nr_mieszkania', '$miasto', '$kod_pocztowy', '$telefon')";
            $wynik = mysqli_query($db, $p);
        echo "<h2>Rejestracja zakończona sukcesem";
        }
    }else{
        echo "<h2>Wpisz numer telefonu według wzoru!</h2>";
    }
}else{
    echo "<h2>Wpisz kod pocztowu według wzoru!</h2>";
}
?>