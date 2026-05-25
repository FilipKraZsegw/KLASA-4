<?php
session_start();

$errors = [];
$success ="";

$imie_nazwisko = "";
$email = "";
$rola = "";
$regulamin = false;

if(isset($_POST['zapisz'])){

    $imie_nazwisko = trim(htmlspecialchars($_POST['imie_nazwisko']));
    $email = trim(htmlspecialchars($_POST['email']));
    $rola = trim(htmlspecialchars($_POST['rola']));
    $regulamin = isset($_POST['regulamin']);

    if(empty($imie_nazwisko)){
        $errors[] = "Pole imie i nazwisko jest puste!";
    }elseif (mb_strlen($imie_nazwisko) < 5){
        $errors[] = "Pole imie i nazwisko musi zawierać conajmniej 5 znaków!";
    }

    if(empty($email)){
        $errors[] = "Pole email jest puste!";
    }elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)){
        $errors[] = "Podano zły adres email!";
    }

    if(empty($rola)){
        $errors[] = "Wybierz rolę!";
    }

    if(!$regulamin){
        $errors[] = "Musisz zaakceptować regulamin!";
    }

    // TO MUSI BYĆ W ŚRODKU
    if(empty($errors)){

        $_SESSION['uczestnik'] = [
            'imie_nazwisko' => $imie_nazwisko,
            'email' => $email,
            'rola' => $rola
        ];

        $success = "Rejestracja zakończona powodzeniem, Witaj ". $imie_nazwisko;

        $imie_nazwisko = "";
        $email = "";
        $rola = "";
        $regulamin = false;
    }
}

?>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rejestracja</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">

    <h1>Rejestracja uczestnika</h1>

    <?php if(!empty($errors)): ?>
        <div class="error_box">
            <ul>
                <?php foreach($errors as $error): ?>
                    <li><?php echo $error; ?></li>
                <?php endforeach; ?>
            </ul>
        </div>
    <?php endif; ?>

    <?php if(!empty($success)): ?>
        <div class="success-box">
            <?php echo $success; ?>
        </div>
    <?php endif; ?>

    <form action="index.php" method="POST">
        <label for="imie_nazwisko">Imie i nazwisko</label>
        <input type="text" id="imie_nazwisko" name="imie_nazwisko" value="<?php echo $imie_nazwisko; ?>">
        <label for="email">Adres e-mail</label>
        <input type="email" id="email" name="email" value="<?php echo $email; ?>">

        <label for="rola">Rola na konferencji</label>
        <select id="rola" name="rola">
            <option value="">-- Wybierz opcję --</option>
            <option value="Słuchacz" <?php if($rola == "Słuchacz") echo "selected";?>>
                Słuchacz
            </option>
            <option value="Prelegent" <?php if($rola == "Prelegent") echo "selected";?>>
                Prelegent
            </option>
            <option value="Sponsor" <?php if($rola == "Sponsor") echo "selected";?>>
                Sponsor
            </option>
        </select>

    <div class="checkbox">
        <input type="checkbox" id="regulamin" name="regulamin" <?php if($regulamin) echo "checked"; ?>>
        <label for="regulamin" style="display:inline;">
            Akceptuję regulamin
        </label>
    </div>

    <button type="submit" name="zapisz">
        Zarejestruj
    </button>

    </form>
    </div>
</body>
</html>