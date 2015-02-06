CREATE TABLE "Contact"(
  "_id" INTEGER PRIMARY KEY NOT NULL,
  "validated" BIT NOT NULL
);
CREATE TABLE "Playlist"(
  "_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "title" VARCHAR(75) NOT NULL,
  "rate" INTEGER NOT NULL,
  "date" DATETIME NOT NULL,
  "fav" BIT NOT NULL,
  "Contact__id" INTEGER,
  CONSTRAINT "fk_Playlist_Contact1"
    FOREIGN KEY("Contact__id")
    REFERENCES "Contact"("_id")
);
CREATE INDEX "Playlist.fk_Playlist_Contact1_idx" ON "Playlist"("Contact__id");
CREATE TABLE "Song"(
  "_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "link" VARCHAR(255) NOT NULL,
  "artiste" VARCHAR(45) NOT NULL,
  "title" VARCHAR(45) NOT NULL,
  "date" DATETIME NOT NULL,
  "Playlist__id" INTEGER NOT NULL,
  CONSTRAINT "fk_Song_Playlist"
    FOREIGN KEY("Playlist__id")
    REFERENCES "Playlist"("_id")
);
CREATE INDEX "Song.fk_Song_Playlist_idx" ON "Song"("Playlist__id");
CREATE TABLE "Comments"(
  "_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "text" TEXT NOT NULL, 
  "Playlist__id" INTEGER NOT NULL,
  "Contact__id" INTEGER NOT NULL,
  CONSTRAINT "fk_Comments_Playlist1"
    FOREIGN KEY("Playlist__id")
    REFERENCES "Playlist"("_id"),
  CONSTRAINT "fk_Comments_Contact1"
    FOREIGN KEY("Contact__id")
    REFERENCES "Contact"("_id")
);
CREATE INDEX "Comments.fk_Comments_Playlist1_idx" ON "Comments"("Playlist__id");
CREATE INDEX "Comments.fk_Comments_Contact1_idx" ON "Comments"("Contact__id");