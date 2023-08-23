INSERT INTO users (id, email, first_name, lastname, image_url, is_active, password)
VALUES (1, "cant_u_see@abv.bg", 'Ivan', 'Ivanov', null , 1, "9311d59c4fe9cbb754ac50af91eae5065a9ec539fc2c88b841f00b529afce4908ec284162fc6ed92");

INSERT INTO brands (id, name)
VALUES (1,"Ford"),(2,"Toyota");

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1,"Fiesta","CAR", 1976, null, 1, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/800px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg"),
    (2,"Escort","CAR", 1968, 2000, 1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKoUd9L2Ga2R8amHkkwr__P8wNPTT4l3Ji2-JC2xVE&s"),
    (3,"Yaris","CAR", 1999, null, 2,"https://images.ams.bg/images/galleries/111829/toyota-yaris-1460818537_big.jpg");