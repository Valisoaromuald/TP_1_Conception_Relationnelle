-- =============================
-- TABLE categorie
-- =============================
CREATE TABLE categorie(
   id_categorie SERIAL PRIMARY KEY,
   libelle VARCHAR(50) NOT NULL
);

-- =============================
-- TABLE participant
-- =============================
CREATE TABLE participant(
   id_participant SERIAL PRIMARY KEY,
   nom VARCHAR(50) NOT NULL,
   prenoms VARCHAR(50)
);

-- =============================
-- TABLE rallye
-- =============================
CREATE TABLE rallye(
   id_rallye SERIAL PRIMARY KEY,
   nom VARCHAR(50) NOT NULL,
   date_realisation DATE NOT NULL
);

-- =============================
-- TABLE equipage
-- =============================
CREATE TABLE equipage(
   id_equipage SERIAL PRIMARY KEY,
   id_categorie INTEGER NOT NULL,
   pilote INTEGER NOT NULL,
   copilote INTEGER NOT NULL,
   FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie),
   FOREIGN KEY(pilote) REFERENCES participant(id_participant),
   FOREIGN KEY(copilote) REFERENCES participant(id_participant)
);

-- =============================
-- TABLE speciale
-- =============================
CREATE TABLE speciale(
   id_speciale SERIAL PRIMARY KEY,
   distance NUMERIC(10,2) NOT NULL,
   nom_special VARCHAR(50) NOT NULL,
   id_rallye INTEGER NOT NULL,
   FOREIGN KEY(id_rallye) REFERENCES rallye(id_rallye)
);

-- =============================
-- TABLE speciale_equipage
-- =============================
CREATE TABLE speciale_equipage(
   id_equipage INTEGER NOT NULL,
   id_speciale INTEGER NOT NULL,
   duree INTERVAL NOT NULL,
   PRIMARY KEY(id_equipage, id_speciale),
   FOREIGN KEY(id_equipage) REFERENCES equipage(id_equipage),
   FOREIGN KEY(id_speciale) REFERENCES speciale(id_speciale)
);


-- donnees d'insertion
INSERT INTO categorie (libelle) VALUES
('R5'),
('R4'),
('M12'),
('M11'),
('M10');

INSERT INTO participant (nom, prenoms) VALUES
('Ogier', 'Sébastien'),
('Landais', 'Vincent'),
('Rovanperä', 'Kalle'),
('Halttunen', 'Jonne'),
('Neuville', 'Thierry'),
('Wydaeghe', 'Martijn'),
('Tanak', 'Ott'),
('Jarveoja', 'Martin');


INSERT INTO rallye (nom, date_realisation) VALUES
('rallye de Monte-Carlo', '2025-01-20'),
('rallye de Finlande', '2025-08-05');


INSERT INTO equipage (id_categorie, pilote, copilote) VALUES
(1, 1, 2),  -- Ogier / Landais
(1, 3, 4),  -- Rovanperä / Halttunen
(1, 5, 6),  -- Neuville / Wydaeghe
(1, 7, 8);  -- Tanak / Jarveoja


INSERT INTO speciale (distance, nom_special, id_rallye) VALUES
(18.20, 'Col de Turini', 1),
(25.60, 'Sisteron', 1),
(20.45, 'Gap', 1),
(16.70, 'Ouninpohja', 2),
(22.10, 'Harju', 2);


-- Monte-Carlo
INSERT INTO speciale_equipage (id_equipage, id_speciale, duree) VALUES
(1, 1, INTERVAL '00:31:23.45'),
(2, 1, INTERVAL '00:30:55.22'),
(3, 1, INTERVAL '00:32:14.10'),
(4, 1, INTERVAL '00:31:58.87'),

(1, 2, INTERVAL '00:27:11.90'),
(2, 2, INTERVAL '00:26:59.33'),
(3, 2, INTERVAL '00:27:45.01'),
(4, 2, INTERVAL '00:27:22.54'),

(1, 3, INTERVAL '00:25:41.50'),
(2, 3, INTERVAL '00:25:21.13'),
(3, 3, INTERVAL '00:25:49.88'),
(4, 3, INTERVAL '00:26:00.02');

-- Finlande
INSERT INTO speciale_equipage (id_equipage, id_speciale, duree) VALUES
(1, 4, INTERVAL '00:17:05.30'),
(2, 4, INTERVAL '00:16:48.20'),
(3, 4, INTERVAL '00:17:11.75'),
(4, 4, INTERVAL '00:16:55.62'),

(1, 5, INTERVAL '00:11:25.44'),
(2, 5, INTERVAL '00:11:11.09'),
(3, 5, INTERVAL '00:11:38.00'),
(4, 5, INTERVAL '00:11:19.88');



-- Affichage des temps par speciale

select 
    se.id_equipage,
    sp.nom_special,
    se.duree
   FROM 
   speciale_equipage se
   JOIN  speciale sp
   ON sp.id_speciale = se.id_speciale
   ORDER BY sp.id_speciale
;
-- Affichage du temps global

CREATE OR REPLACE VIEW temps_global as
select id_equipage,
        sum(duree) as temps_total
    FROM speciale_equipage
    GROUP BY id_equipage
    ORDER BY temps_total asc;
