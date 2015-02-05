CREATE VIEW [Playlist_list] AS 
SELECT * FROM Playlist 
INNER JOIN Contact on Contact._id = Playlist.Contact__id 
ORDER BY Contact__id;


CREATE VIEW [Playlist_element] AS 
SELECT * FROM Playlist 
INNER JOIN Song on Song.Playlist__id=Playlist._id 
INNER JOIN Contact on Contact._id = Playlist.Contact__id 
ORDER BY Contact__id;