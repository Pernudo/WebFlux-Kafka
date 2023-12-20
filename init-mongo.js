db = db.getSiblingDB('Web_Flux');

db.createUser({
        user: "admin",
        pwd: "Web_FluxMongoDB",
        roles: [{ role: 'readWrite', db: 'Web_Flux' }],
});

db.createCollection("products");

db.products.insert({"id_product": 100, "name": "Azúcar", "category": "Alimentación", "price": 1.1, "stock": 20});
db.products.insert({"id_product": 101, "name": "Leche", "category": "Alimentación", "price": 1.2, "stock": 15});
db.products.insert({"id_product": 102, "name": "Jabón", "category": "Limpieza", "price": 0.89, "stock": 30});
db.products.insert({"id_product": 103, "name": "Mesa", "category": "Hogar", "price": 125.0, "stock": 4});
db.products.insert({"id_product": 104, "name": "Televisión", "category": "Hogar", "price": 650.0, "stock": 10});
db.products.insert({"id_product": 105, "name": "Huevos", "category": "Alimentación", "price": 2.2, "stock": 30});
db.products.insert({"id_product": 106, "name": "Fregona", "category": "Limpieza", "price": 3.4, "stock": 6});
db.products.insert({"id_product": 107, "name": "Detergente", "category": "Limpieza", "price": 8.7, "stock": 12});