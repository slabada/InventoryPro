insert INTO product(name, description, price) values ('testName', 'testDescription', 123);
insert INTO product(name, description, price) values ('testNameUpdate', 'testDescriptionUpdate', 123);
insert INTO product(name, description, price) values ('testNameDelete', 'testDescriptionDelete', 123);
insert INTO product(name, description, price) values ('testName_inventory', 'testDescription_inventory', 123);

insert INTO location(sector, wardrobe, shelf) values ('testSector', 'testWardrobe', 'testShelf');
insert INTO location(sector, wardrobe, shelf) values ('testSectorUpdate', 'testWardrobeUpdate', 'testShelfUpdate');
insert INTO location(sector, wardrobe, shelf) values ('testSectorDelete', 'testWardrobeDelete', 'testShelfDelete');
insert INTO location(sector, wardrobe, shelf) values ('testSector_inventory', 'testWardrobe_inventory', 'testShelf_inventory');

insert INTO inventory(quantity) values (123);
insert INTO inventory(quantity) values (123);
insert INTO inventory(quantity) values (123);
insert INTO inventory(quantity) values (123);

insert INTO inventory_product(inventory_id, product_id) VALUES (1,4);
insert INTO inventory_location(inventory_id, location_id) VALUES (1,4);

insert INTO inventory_product(inventory_id, product_id) VALUES (2,4);
insert INTO inventory_location(inventory_id, location_id) VALUES (2,4);

insert INTO product(name, description, price) values ('testName_inventoryUpdate', 'testDescription_inventoryUpdate', 123);
insert INTO location(sector, wardrobe, shelf) values ('testSector_inventoryUpdate', 'testWardrobe_inventoryUpdate', 'testShelf_inventoryUpdate');
