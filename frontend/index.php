<?php 
    $url = "http://localhost:8080/pets/list";
    $data = file_get_contents($url);
    $pets = json_decode($data, true);
    
   // var_dump($pets)
?>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <title>Listado de mascotas</title>
    </head>
    <body>
        <table class="table table-striped">
                <thead>
                <h1>Listado de mascotas</h1>
                    <tr>
                        <td>ID</td>
                        <td>name</td>
                        <td>chip</td>
                        <td>category</td>
                        <td>born</td>
                        <td>adopt</td>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach($pets as $pet): ?>
                        <tr>
                            <td><?php echo $pet['id'] ?></td>
                            <td><?php echo $pet['name'] ?></td>
                            <td><?php echo $pet['chip'] ?></td>
                            <td><?php echo $pet['category'] ?></td>
                            <td><?php echo $pet['born'] ?></td>
                            <td><?php if($pet['adopt'] == FALSE) { ?>
                                <form method="POST" action="http://localhost:8080/pets/adopt/<?php echo $pet['id'] ?>">
                                    <button type="submit" class="btn btn-primary">Adoptar</button>
                                </form>
                                <?php } else {
                                    echo "Esta adoptado";
                                }?>
                            </td> 
                        </tr>
                    <?php endforeach; ?>
        </table> 
        
    </body>
</html>