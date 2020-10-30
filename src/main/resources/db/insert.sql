use netflix2;

insert into categories (id, name, create_date, update_date) VALUES
(1,'documentary', now(), now()),
(2,'drama', now(), now()),
(3,'thriller', now(), now()),
(4,'short film', now(), now()),
(5,'historical', now(), now()),
(6,'comedy drama', now(), now()),
(7,'animated', now(), now()),
(8,'war', now(), now()),
(9,'biographical', now(), now()),
(10,'superhero', now(), now()),
(11,'musical', now(), now()),
(12,'romantic', now(), now())
;

insert into films (id, category_id, name, year, country, language, duration, short_desc, long_desc, create_date, update_date) VALUES
( 1, 2, 'Ford v Ferrari', 2019, 'United States','English', 152, 'sports drama film','American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at the 24 Hours of Le Mans in 1966.', now(), now()),
( 2, 3, 'Parasite (Gisaengchung (기생충))', 2019, 'South Korea','Korean', 132, 'black comedy thriller film','follows the members of a poor family who scheme to become employed by a wealthy family by infiltrating their household and posing as unrelated, highly qualified individuals.', now(), now()),
( 3, 1, 'Learning to Skateboard in a Warzone (If You are a Girl)', 2019, 'United Kingdom','English', 39, 'documentary short film','The film is about Skateistan, a nonprofit organization, which started as a skate school in 2007 for girls from impoverished neighborhoods learning to read, write, and skateboard in Kabul, Afghanistan, where young women are not allowed to participate in sporting activities.', now(), now()),
( 4, 4, 'The Neighbors Window', 2019, 'United States','English', 20, 'short film','Inspired by a true story, the short film tells the story of Alli (Maria Dizzia), a mother of young children who has grown frustrated with her daily routine and husband (Greg Keller). But her life is shaken up when two free-spirited twenty-somethings move in across the street and she discovers that she can see into their apartment.', now(), now()),
( 5, 5, 'Little Women', 2019, 'United States','English', 135, 'coming-of-age period drama film','Jo March reflects back and forth on her life, telling the beloved story of the March sisters - four young women, each determined to live life on her own terms.', now(), now()),
( 6, 2, 'Marriage Story', 2019, 'United States','English', 137, 'drama film','Noah Baumbach incisive and compassionate look at a marriage breaking up and a family staying together.', now(), now()),
( 7, 6, 'Jojo Rabbit', 2019, 'United States','English', 108, 'comedy-drama film','A young boy in Hitler army finds out his mother is hiding a Jewish girl in their home.', now(), now()),
( 8, 7, 'Toy Story 4', 2019, 'United States','English', 100, 'computer-animated comedy film','When a new toy called "Forky" joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.', now(), now()),
( 9, 3, 'Joker', 2019, 'United States','English', 122, 'phychological thriller','In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.', now(), now()),
( 10, 6, 'Once Upon a Time in Hollywood', 2019, 'United States','English', 161, 'comedy-drama film','A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood Golden Age in 1969 Los Angeles.', now(), now()),
( 11, 8, '1917', 2019, 'United States','English', 119, 'war film','April 6th, 1917. As a regiment assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap.', now(), now()),
( 12, 9, 'Judy', 2019, 'United States','English', 118, 'biographical drama film','Legendary performer Judy Garland arrives in London in the winter of 1968 to perform a series of sold-out concerts.', now(), now()),
( 13, 2, 'Bombshell', 2019, 'United States','English', 108, 'american drama film','A group of women take on Fox News head Roger Ailes and the toxic atmosphere he presided over at the network.', now(), now()),
( 14, 9, 'Rocketman', 2019, 'United Kingdom','English', 121, 'biographical musical film','A musical fantasy about the fantastical human story of Elton John breakthrough years.', now(), now()),
( 15, 1, 'American Factory', 2019, 'United States','English', 110, 'documentary film','In post-industrial Ohio, a Chinese billionaire opens a factory in an abandoned General Motors plant, hiring two thousand Americans. Early days of hope and optimism give way to setbacks as high-tech China clashes with working-class America.', now(), now()),
( 16, 7, 'Hair Love', 2019, 'United States','English', 9, 'animated short film','A father tries to do his daughter hair for the first time.', now(), now()),
( 17, 2, 'Corpus Christi (Boże Ciało)', 2019, 'Poland','Polish', 116, 'drama film','Daniel experiences a spiritual transformation in a detention center. Although his criminal record prevents him from applying to the seminary, he has no intention of giving up his dream and decides to minister a small-town parish.', now(), now()),
( 18, 1, 'Honeyland (Медена земја)', 2019, 'North Macedonia','Macedonian', 87, 'documentary film','The last female bee-hunter in Europe must save the bees and return the natural balance in Honeyland, when a family of nomadic beekeepers invade her land and threaten her livelihood.', now(), now()),
( 19, 1, 'Les Misérables', 2019, 'France','French', 103, 'documentary film','A cop from the provinces moves to Paris to join the Anti-Crime Brigade of Montfermeil, discovering an underworld where the tensions between the different groups mark the rhythm.', now(), now()),
( 20, 2, 'Pain and Glory (Dolor y Gloria)', 2019, 'Spain','Spanish', 113, 'drama film','An aging film director suffering from chronic illness and writer block reflects on his life.', now(), now()),
( 21, 9, 'Green Book', 2018, 'United States','English', 130, 'biographical comedy-drama film','A working-class Italian-American bouncer becomes the driver of an African-American classical pianist on a tour of venues through the 1960s American South.', now(), now()),
( 22, 9, 'Bohemian Rhapsody', 2018, 'United Kingdom','English', 134, 'bigraphical drama film','The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid (1985).', now(), now()),
( 23, 2, 'Roma', 2018, 'Mexico','Spanish', 135, 'drama film','A year in the life of a middle-class family maid in Mexico City in the early 1970s.', now(), now()),
( 24, 10, 'Black Panther', 2018, 'United States','English', 134, 'superhero film','TChalla, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger from his country past.', now(), now()),
( 25, 5, 'The Favourite', 2018, 'United Kingdom','English', 120, 'period black comedy film','In early 18th century England, a frail Queen Anne occupies the throne and her close friend, Lady Sarah, governs the country in her stead. When a new servant, Abigail, arrives, her charm endears her to Sarah.', now(), now()),
( 26, 11, 'A Star Is Born', 2018, 'United States','English', 136, 'romantical musical drama film','A musician helps a young singer find fame as age and alcoholism send his own career into a downward spiral.', now(), now()),
( 27, 9, 'Vice', 2018, 'United States','English', 132, 'biographical drama film','The story of Dick Cheney, an unassuming bureaucratic Washington insider, who quietly wielded immense power as Vice President to George W. Bush, reshaping the country and the globe in ways that we still feel today.', now(), now()),
( 28, 9, 'BlacKkKlansman', 2018, 'United States','English', 135, 'biographical black comedy crime film','Ron Stallworth, an African American police officer from Colorado Springs, CO, successfully manages to infiltrate the local Ku Klux Klan branch with the help of a Jewish surrogate who eventually becomes its leader. Based on actual events.', now(), now()),
( 29, 9, 'First Man', 2018, 'United States','English', 141, 'biographical drama film','A look at the life of the astronaut, Neil Armstrong, and the legendary space mission that led him to become the first man to walk on the Moon on July 20, 1969.', now(), now()),
( 30, 12, 'If Beale Street Could Talk', 2018, 'United States','English', 117, 'romantic drama film','A young woman embraces her pregnancy while she and her family set out to prove her childhood friend and lover innocent of a crime he didnt commit.', now(), now()),
( 31, 7, 'Bao', 2018, 'United States','Mute', 8, 'computer-animated short film','In Toronto, Canada, a Chinese-Canadian woman is suffering from empty nest syndrome as her husband is busy at work. She makes a steamed bun that comes alive before she starts to eat it and begins to cry like an infant. She raises the steamed bun as a child. Bao acts as a story about food and family and how the two come together to form a "potent emotional resonance.', now(), now()),
( 32, 1, 'Free Solo', 2018, 'United States','English', 100, 'documentary film','Alex Honnold attempts to become the first person to ever free solo climb El Capitan.', now(), now()),
( 33, 1, 'Period. End of Sentence.', 2018, 'United States','Hindi', 25, 'documentary short film','short film bout Indian women leading a quiet sexual revolution.', now(), now()),
( 34, 4, 'Skin', 2018, 'United States','English', 20, 'short drama film','short film about racism', now(), now()),
( 35, 7, 'Spider-Man: Into the Spider-Verse', 2018, 'United States','English', 117, 'computer-animated superhero film','Teen Miles Morales becomes Spider-Man of his reality, crossing his path with five counterparts from other dimensions to stop a threat for all realities.', now(), now()),
( 36, 2, 'Capernaum (Capharnaüm (کفرناحوم))', 2018, 'Lebanon','Arabic', 126, 'drama film','While serving a five-year sentence for a violent crime, a 12-year-old boy sues his parents for neglect.', now(), now()),
( 37, 5, 'Cold War (Zimna wojna)', 2018, 'Poland','Polish', 88, 'historical drama film','In the 1950s, a music director falls in love with a singer and tries to persuade her to flee communist Poland for France.', now(), now()),
( 38, 12, 'Never Look Away (Werk ohne Autor)', 2018, 'Germany','German', 188, 'coming-of-age romantic drama film','German artist Kurt Barnert has escaped East Germany and now lives in West Germany, but is tormented by his childhood under the Nazis and the DDR-regime.', now(), now()),
( 39, 2, 'Shoplifters (Manbiki Kazoku (万引き家族))', 2018, 'Japan','Japanese', 121, 'drama film','A family of small-time crooks take in a child they find outside in the cold.', now(), now());

insert into roles (id, name, create_date, update_date) values ('1', 'actor', now(), now());
insert into roles (id, name, create_date, update_date) values ('2', 'director', now(), now());
insert into roles (id, name, create_date, update_date) values ('3', 'screenwriter', now(), now());

insert into persons (id, name, surname, birthday_year, create_date, update_date) values ('1', 'Leonardo', 'DiCaprio', 1985, now(), now());
insert into persons (id, name, surname, birthday_year, create_date, update_date) values ('2', 'Angelina', 'Jolie', 1985, now(), now());
insert into persons (id, name, surname, birthday_year, create_date, update_date) values ('3', 'Seteven', 'Spielberg', 1960, now(), now());
insert into persons (id, name, surname, birthday_year, create_date, update_date) values ('4', 'James', 'Cameron', 1962, now(), now());

insert into casts (id, person_id, role_id, film_id, create_date, update_date) VALUES ('1', '1', '1', '24', now(), now());
insert into casts (id, person_id, role_id, film_id, create_date, update_date) VALUES ('2', '2', '1', '28', now(), now());
insert into casts (id, person_id, role_id, film_id, create_date, update_date) VALUES ('3', '3', '2', '4', now(), now());
insert into casts (id, person_id, role_id, film_id, create_date, update_date) VALUES ('4', '4', '2', '7', now(), now());