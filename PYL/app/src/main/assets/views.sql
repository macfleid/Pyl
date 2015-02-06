CREATE VIEW [Playlist_list] AS 
SELECT *, 
 Contact._id as arg_contact_id 
 FROM Playlist 
LEFT OUTER JOIN Contact on Contact._id = Playlist.Contact__id 
ORDER BY Contact__id;


CREATE VIEW [Playlist_element] AS 
SELECT * FROM Playlist 
INNER JOIN Song on Song.Playlist__id=Playlist._id 
LEFT OUTER JOIN Contact on Contact._id = Playlist.Contact__id 
ORDER BY Contact__id;