package org.example;

public class Books {
    public Book[] inventory(){
        Book[] books = new Book[20];
        books[0] = new Book(1, "978-6-83-569305-9", "Unearthed Arcana");
        books[1] = new Book(2, "978-8-47-458044-5", "Basic Rules");
        books[2] = new Book(3, "978-4-09-856348-6", "Player's Handbook");
        books[3] = new Book(4, "978-8-68-458430-9", "Dungeon Master's Guide");
        books[4] = new Book(5, "978-4-36-239634-1", "Volo's Guide to Monsters");
        books[5] = new Book(6, "978-0-744-73795-6", "Wayfinder's Guide to Eberron");
        books[6] = new Book(7, "978-8-856-23427-8", "Guidmasters' Guide to Ravnica");
        books[7] = new Book(8, "978-5-95-234523-6", "Mordenkainen's Tome of Foes");
        books[8] = new Book(9, "978-9-489-23532-4", "Xanathar's Guide to Everything");
        books[9] = new Book(10, "978-1-954-63637-2", "Sword Coast Adventurer's Guide");
        books[10] = new Book(11, "978-6-478-54376-5", "Mythic Odyssey's of Theros");
        books[11] = new Book(12, "978-5-49848-856-0", "Eberron: Rising from the Last War");
        books[12] = new Book(13, "978-4-493-95696-6", "Tasha's Cauldron of Everythingg");
        books[13] = new Book(14, "978-8-48-523572-9", "The Tortle Package");
        books[14] = new Book(15, "978-3-945-62327-5", "Sage Advice Compendium");
        books[15] = new Book(16, "978-4-84584-243-6", "Domain's of Delight: A Feywild Accessory");
        books[16] = new Book(17, "978-8-485-53346-9", "Fizban's Treasury of Dragons");
        books[17] = new Book(18, "978-5-845-63466-2", "Spelljammer: Adventures in Space");
        books[18] = new Book(19, "978-3-945-32943-6", "The Vecna Dossier");
        books[19] = new Book(20, "978-8-595-52843-2", "Thieves' Gallery");
        return books;
    }
}