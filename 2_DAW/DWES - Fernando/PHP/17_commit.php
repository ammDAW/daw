<?php
try {
    $dbh = new PDO('mysql:host=localhost;dbname=test', 'root', '');
    
    try {
        $dbh->beginTransaction();
        $stmt = $dbh->prepare("INSERT INTO personas (nombre, apellidos) VALUES(?,?)");
        $stmt->execute( array('pepe', 'lopez'));
        $stmt = $dbh->prepare("INSERT INTO personas (name, apellidos) VALUES(?,?)");
        $stmt->execute( array('pepe', 'lopez'));
        $dbh->commit();
        print $dbh->lastInsertId();
    } catch(PDOException $e) {
        $dbh->rollback();
        print "Error!: " . $e->getMessage() . "</br>";
    }
} catch(PDOException $e) {
    print "Error!: " . $e->getMessage() . "</br>";
}
?>