CREATE TABLE IF NOT EXISTS item(

    id serial NOT NULL PRIMARY KEY,
    title varchar (100),
    price varchar (50),
    merchant varchar (50),
    describer varchar (300)

)