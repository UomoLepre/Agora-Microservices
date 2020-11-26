agora-catalogo e agora-eureka sono due package da far eseguire in due ambienti differenti.

agora-eureka deve essere necessariamente avviato per primo.

agora-catalogo è un microservizio che permette di effettuare le operazioni CRUD (CREATE, READ, UPDATE, DELETE) su un database.
agora-catalogo è configurato affinche funzioni con un database generato nella porta di default 3306, generata dal software xamp.

Xampp è possibile scaricarlo online. Per l'installazione basta seguire i settaggi di default. Una vola installato è necessario avviare Apache e Mysql da xampp control.
Una volta configurato, collegarsi al link url localhost:80/phpmyadmin.
E' necessario importare all'interno di questo url il database presente nel file.

Per testare il funzionamento del microservizio, consigliamo l'utilizzo di postman, anche quest'ultimo è possibile scaricarlo online.
