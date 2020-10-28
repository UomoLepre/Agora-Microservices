-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 13, 2019 alle 23:17
-- Versione del server: 10.4.8-MariaDB
-- Versione PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `catalogo`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `id` int(11) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `immagine` varchar(255) DEFAULT NULL,
  `nome_prodotto` varchar(255) DEFAULT NULL,
  `partita_iva` int(11) DEFAULT NULL,
  `prezzo` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`id`, `descrizione`, `immagine`, `nome_prodotto`, `partita_iva`, `prezzo`) VALUES
(1000, 'descrizione', 'immagine', 'Merluzzo', 1000, 2),
(1001, 'descrizione', 'immagine', 'Salmone', 1000, 3),
(1002, 'descrizione', 'immagine', 'Tonno', 1000, 4),
(1003, 'descrizione', 'immagine', 'Pane', 1001, 1),
(1005, 'descrizione', 'immagine', 'Hamburger', 1002, 3),
(1006, 'descrizione', 'immagine', 'Carne di manzo', 1002, 5),
(1007, 'descrizione', 'immagine', 'Petto di pollo', 1002, 4),
(1008, 'descrizione', 'immagine', 'Acqua', 1003, 1),
(1009, 'descrizione', 'immagine', 'Pasta', 1003, 2),
(1010, 'descrizione', 'immagine', 'Biscotti', 1004, 2),
(1011, 'descrizione', 'immagine', 'Taralli', 1004, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `store`
--

CREATE TABLE `store` (
  `partita_iva` int(11) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `immagine` varchar(255) DEFAULT NULL,
  `nome_store` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `store`
--

INSERT INTO `store` (`partita_iva`, `categoria`, `descrizione`, `immagine`, `nome_store`) VALUES
(1000, 'Alimentari', 'descrizione', 'immagine', 'Pesceria'),
(1001, 'Alimentari', 'descrizione', 'immagine', 'Panificio'),
(1002, 'Alimentari', 'descrizione', 'immagine', 'Macelleria'),
(1003, 'Supermercati', 'descrizione', 'immagine', 'Coop');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbtjmgt5txfqpreckcy8fvmgb7` (`partita_iva`);

--
-- Indici per le tabelle `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`partita_iva`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
