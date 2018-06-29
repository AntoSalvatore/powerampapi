/*
Copyright (C) 2011-2014 Maksim Petrov

Redistribution and use in source and binary forms, with or without
modification, are permitted for widgets, plugins, applications and other software
which communicate with Poweramp application on Android platform.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE FOUNDATION OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.maxmpz.poweramp.player;

import org.eclipse.jdt.annotation.NonNull;
import android.provider.BaseColumns;

public interface TableDefs {
	/**
	 * Alias used for category. Useful when query is actually a multi table join.
	 */
	public static final @NonNull String CATEGORY_ALIAS = "cat";

	public static final long UNKNOWN_ID = 1000L;

	public static final @NonNull String NUM_FILES_ALL = "num_files AS num_files_total";
	public static final @NonNull String NUM_FILES_NO_CUE = "(num_files - num_cue_files) AS num_files_total";


	/**
	 * Alias used for category aliased table _id.
	 */
	public static final @NonNull String CATEGORY_ALIAS_ID = CATEGORY_ALIAS + "._id";


	public interface Files {
		public static final @NonNull String TABLE = "folder_files";
		public static final @NonNull String VIEW_MOST_PLAYED = "files_most_played";
		public static final @NonNull String VIEW_TOP_RATED = "files_most_played";
		public static final @NonNull String VIEW_RECENTLY_ADDED = "files_recently_added";
		public static final @NonNull String VIEW_RECENTLY_ADDED_FS = "files_recently_added_fs"; // REVISIT
		public static final @NonNull String VIEW_RECENTLY_PLAYED = "files_recently_played";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Short filename.
		 * String.
		 */
		public static final @NonNull String NAME = TABLE + ".name";

		/*
		 * Track number (extracted from filename).
		 * Int.
		 */
		public static final @NonNull String TRACK_NUMBER = "track_number";

		/*
		 * Track name without number.
		 * String.
		 */
		public static final @NonNull String NAME_WITHOUT_NUMBER = "name_without_number";

		/*
		 * One of the TAG_* constants.
		 * Int.
		 */
		public static final @NonNull String TAG_STATUS = "tag_status";

		/*
		 * Track # tag.
		 * Int.
		 */
		public static final @NonNull String TRACK_TAG = "track_tag";

		/*
		 * Parent folder id.
		 * Int.
		 */
		public static final @NonNull String FOLDER_ID = "folder_id";

		/*
		 * Title tag.
		 * String.
		 */
		public static final @NonNull String TITLE_TAG = TABLE + ".title_tag"; // REVISIT: remove TABLE

		/*
		 * Duration in miliseconds.
		 * Int.
		 */
		public static final @NonNull String DURATION = "duration";

		/*
		 * Int.
		 */
		public static final @NonNull String UPDATED_AT = TABLE + ".updated_at";

		/*
		 * One of the file types - see PowerAMPiAPI.Track.FileType class.
		 */
		public static final @NonNull String FILE_TYPE = "file_type";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";
		/*
		 * Int.
		 */
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";

		/*
		 * Int.
		 * This is file last modified time actually, for most filesystems
		 */
		public static final @NonNull String FILE_CREATED_AT = "file_created_at";

		/*
		 * Bitwise flag.
		 * Int.
		 */
		public static final @NonNull String AA_STATUS = TABLE + ".aa_status";

		/*
		 * Full path. Works only if the query is joined with the folders.
		 * String.
		 */
		public static final @NonNull String FULL_PATH = Folders.PATH + "||" + NAME;

		/*
		 * Int.
		 */
		public static final @NonNull String RATING = "rating";

		/*
		 * Int.
		 */
		public static final @NonNull String PLAYED_TIMES = TABLE + ".played_times";

		/*
		 * Int.
		 */
		public static final @NonNull String ALBUM_ID = TABLE + ".album_id";

		/*
		 * Int.
		 */
		public static final @NonNull String ARTIST_ID = TABLE + ".artist_id";

		/*
		 * Int.
		 */
		public static final @NonNull String ALBUM_ARTIST_ID = TABLE + ".album_artist_id";

		/*
		 * Int.
		 */
		public static final @NonNull String COMPOSER_ID = TABLE + ".composer_id";

		/*
		 * Int.
		 */
		public static final @NonNull String YEAR = "year";

		/*
		 * Int.
		 */
		public static final @NonNull String OFFSET_MS = "offset_ms";

		/*
		 * If non-null - this is cue "source" (big single uncut) file with that given virtual folder id 
		 * Int.
		 */
		public static final @NonNull String CUE_FOLDER_ID = "cue_folder_id";

		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
		
		/**
		 * Wave scan data
		 * byte[] blob, nullable
		 */
		public static final @NonNull String WAVE = "wave";
		
		/**
		 * String
		 */
		public static final @NonNull String META = TABLE + ".meta";
		
		//public static final @NonNull String TITLE_OR_NAME = "ifnull(" + TABLE + ".title_tag, " + TABLE + ".name)";


		/**
		 * tag_status
		 */
		public static final int TAG_NOT_SCANNED = 0;
		/**
		 * tag_status
		 */
		public static final int TAG_SCANNED = 1;

	}

	
	public interface RawFiles extends Files {
		public static final @NonNull String TABLE = "raw_files";

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Short filename.
		 * String.
		 */
		public static final @NonNull String NAME = TABLE + ".name";

		/*
		 * Title tag.
		 * String.
		 */
		public static final @NonNull String TITLE_TAG = TABLE + ".title_tag";

		/*
		 * Int.
		 */
		public static final @NonNull String UPDATED_AT = TABLE + ".updated_at";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";
		/*
		 * Int.
		 */
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";

		/*
		 * Full path. Works only if the query is joined with the folders.
		 * String.
		 */
		public static final @NonNull String FULL_PATH = Folders.PATH + "||" + NAME;

		/*
		 * Int.
		 */
		public static final @NonNull String PLAYED_TIMES = TABLE + ".played_times";

		/*
		 * Int.
		 */
		public static final @NonNull String ALBUM_ID = TABLE + ".album_id";

		/*
		 * Int.
		 */
		public static final @NonNull String ARTIST_ID = TABLE + ".artist_id";

		/*
		 * Int.
		 */
		public static final @NonNull String ALBUM_ARTIST_ID = TABLE + ".album_artist_id";

		/*
		 * Int.
		 */
		public static final @NonNull String COMPOSER_ID = TABLE + ".composer_id";

		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
		
		/**
		 * String
		 */
		public static final @NonNull String META = TABLE + ".meta";
		
		/**
		 * String
		 */
		public static final @NonNull String ALBUM_TAG = TABLE + ".album_tag";
		
		/**
		 * String
		 */
		public static final @NonNull String ARTIST_TAG = TABLE + ".artist_tag";
	}


	public interface Folders {
		public static final @NonNull String TABLE = "folders";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * volume_id (fatID) of the storage.
		 * Int.
		 */
		//public static final @NonNull String VOLUME_ID = TABLE + ".volume_id";

		/*
		 * Short name of the folder.
		 * String.
		 */
		public static final @NonNull String NAME = TABLE + ".name";

		/*
		 * Short path of the parent folder.
		 * String.
		 */
		public static final @NonNull String PARENT_NAME = TABLE + ".parent_name";

		/*
		 * Full path of the folder.
		 * String.
		 */
		public static final @NonNull String PATH = "path"; //TABLE + ".path"; // NOTE: avoid TABLE name here to allow using field in raw_files. "path" is unique column, anyways

		/*
		 * Folder album art/thumb image (short name).
		 * String.
		 */
		public static final @NonNull String THUMB = "thumb";//TABLE + ".thumb";

		/*
		 * One of the THUMB_* constants.
		 * Int.
		 */
		//public static final @NonNull String THUMB_STATUS = "thumb_status"; //TABLE + ".thumb_status"; // Not used anymore

		/*
		 * Number of files in a folder.
		 * Int.
		 */
		public static final @NonNull String NUM_FILES = TABLE + ".num_files";

		/*
		 * Int.
		 */
		public static final @NonNull String DIR_MODIFIED_AT = TABLE + ".dir_modified_at";

		/*
		 * Int.
		 */
		public static final @NonNull String UPDATED_AT = TABLE + ".updated_at";
		/*
		 * Id of the parent folder or 0 for "root" folders.
		 * Int.
		 */
		public static final @NonNull String PARENT_ID = TABLE + ".parent_id";	
		/*
		 * Number of child subfolders.
		 * Int.
		 */
		public static final @NonNull String NUM_SUBFOLDERS = TABLE + ".num_subfolders";

		/*
		 * Int.
		 */
		public static final @NonNull String IS_CUE = TABLE + ".is_cue";

		/*
		 * Set for real (non-cue-virtual) folders, means number of cue source files inside this folder.
		 * Int.
		 */
		public static final @NonNull String NUM_CUE_FILES = TABLE + ".num_cue_files";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";
		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";

		/*
		 * 
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
		
		
		/**
		 * String.
		 * Special calculated subquery column which retrieves short parent name 
		 */
		public static final @NonNull String PARENT_NAME_SUBQUERY = "(SELECT name FROM folders AS f2 WHERE f2._id=folders.parent_id) AS parent_name_subquery";		

//		/**
//		 * tag_status - some jpeg/png exists for dir
//		 */
//		public static final int THUMB_EXISTS_IMAGE = 10;
//
//		/**
//		 * tag_status - no thumbs for dir detected
//		 */
//		public static final int THUMB_NO_THUMB = 0;
	}


	public interface Albums {
		public static final @NonNull String TABLE = "albums";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * String.
		 */
		public static final @NonNull String ALBUM = "album";

		/*
		 * String.
		 */
		public static final @NonNull String ALBUM_SORT = "album_sort";

		/*
		 * Int
		 */
		public static final @NonNull String ALBUM_ARTIST_ID = TABLE + ".album_artist_id";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";
		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";
		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";

		// Albums uses special where for cue sources, thus just count files is enough.
		public static final @NonNull String COUNT_FILES = "count(folder_files._id)";
	}


	public interface Artists {
		public static final @NonNull String TABLE = "artists";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * String.
		 */
		public static final @NonNull String ARTIST = "artist";

		/*
		 * String.
		 */
		public static final @NonNull String ARTIST_SORT = "artist_sort";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";

		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";

		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
		
		/*
		 * Bitwise flag.
		 * Int.
		 */
		public static final @NonNull String AA_STATUS = TABLE + ".aa_status";
		

		// Artists uses special where for cue sources, thus just count files is enough.
		public static final @NonNull String COUNT_FILES = "count(folder_files._id)";
		
		public static final @NonNull String COUNT_ALBUMS = "count(albums._id)";
	}


	// NOTE: this is similar to Artists
	public interface AlbumArtists {
		public static final @NonNull String TABLE = "album_artists";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * String.
		 */
		public static final @NonNull String ALBUM_ARTIST = "album_artist";

		/*
		 * String.
		 */
		public static final @NonNull String ALBUM_ARTIST_SORT = "album_artist_sort";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";

		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";

		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
		
		/*
		 * Bitwise flag.
		 * Int.
		 */
		public static final @NonNull String AA_STATUS = TABLE + ".aa_status";
		

		// Artists uses special where for cue sources, thus just count files is enough.
		public static final @NonNull String COUNT_FILES = "count(folder_files._id)";
		
		public static final @NonNull String COUNT_ALBUMS = "count(albums._id)";
	}


	// NOTE: this is album => artist 1:1 binding table
	public interface ArtistAlbums {
		public static final @NonNull String TABLE = "artist_albums";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Int.
		 */
		public static final @NonNull String ARTIST_ID = TABLE + ".artist_id";

		/*
		 * Int.
		 */
		public static final @NonNull String ALBUM_ID = TABLE + ".album_id";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";

		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";

		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
	}


	public interface Composers {
		public static final @NonNull String TABLE = "composers";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * String.
		 */
		public static final @NonNull String COMPOSER = "composer";

		public static final @NonNull String COMPOSER_SORT = "composer_sort";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";
		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";
		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
		
		/*
		 * Bitwise flag.
		 * Int.
		 */
		public static final @NonNull String AA_STATUS = TABLE + ".aa_status";
		

		// Composers uses special where for cue sources, thus just count files is enough.
		public static final @NonNull String COUNT_FILES = "count(folder_files._id)";
		
		public static final @NonNull String COUNT_ALBUMS = "count(albums._id)";
	}

	public interface Genres {
		public static final @NonNull String TABLE = "genres";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * String.
		 */
		public static final @NonNull String GENRE = "genre";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";
		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";
		/*
		 * First seen time.
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";

		public static final @NonNull String COUNT_FILES = "count(folder_files._id)";
		
		public static final @NonNull String COUNT_ALBUMS = "count(albums._id)";
	}


	public interface GenreEntries {
		public static final @NonNull String TABLE = "genre_entries";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Actual id of the file in folder_files table.
		 * Long.
		 */
		public static final @NonNull String FOLDER_FILE_ID = "folder_file_id";

		/*
		 * Gerne id.
		 * Long.
		 */
		public static final @NonNull String GENRE_ID = "genre_id";
	}


	public interface PlaylistEntries {
		public static final @NonNull String TABLE = "folder_playlist_entries";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Actual id of the file in folder_files table.
		 * Int.
		 */
		public static final @NonNull String FOLDER_FILE_ID = "folder_file_id";

		/*
		 * Folder Playlist id.
		 * Int.
		 */
		public static final @NonNull String PLAYLIST_ID = "playlist_id";

		/*
		 * Sort order.
		 * Int.
		 */
		public static final @NonNull String SORT = "sort";
	}


	public interface Playlists {
		public static final @NonNull String TABLE = "folder_playlists";

		// Fields.

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Name of the playlist.
		 * String.
		 */
		public static final @NonNull String NAME = TABLE + ".name";

		/*
		 * Int.
		 */
		public static final @NonNull String MTIME = TABLE + ".mtime";

		/*
		 * Int.
		 */
		public static final @NonNull String PATH = TABLE + ".path";

		/*
		 * Int.
		 */
		public static final @NonNull String SSID = TABLE + ".ssid";
		/*
		 * Int.
		 * @deprecated not used anymore
		 */
		@Deprecated
		public static final @NonNull String PLAYED_AT = TABLE + ".played_at";
		/*
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";
		/*
		 * Int.
		 */
		public static final @NonNull String UPDATED_AT = TABLE + ".updated_at";

		public static final @NonNull String NUM_FILES_COUNT = "(SELECT COUNT(*) FROM " + PlaylistEntries.TABLE + " WHERE " + PlaylistEntries.PLAYLIST_ID + "=" + _ID + ") AS _track_count";
		
		// NOTE: requires CTE with durs, e.g.:
		// with durs as (select (sum(duration)) as dur, album from folder_files inner join albums on albums._id=folder_files.album_id group by album_id) 
		//    select (dur/3600000) || ':' || strftime('%M:%S', (dur/86400000.0)), dur, album from durs limit 10;
		
		public static final @NonNull String TOTAL_DURATION = "(dur/3600000) || ':' || strftime('%M:%S', (dur/86400000.0))";
	}




	public class Queue {
		public static final @NonNull String TABLE = "queue";

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Folder file id.
		 * Int.
		 */
		public static final @NonNull String FOLDER_FILE_ID = TABLE + ".folder_file_id";

		/*
		 * Int.
		 */
		public static final @NonNull String CREATED_AT = TABLE + ".created_at";

		/*
		 * Int.
		 */
		public static final @NonNull String SORT = TABLE + ".sort";

		public static final @NonNull String CALC_PLAYED = "folder_files.played_at > queue.created_at";
		public static final @NonNull String CALC_UNPLAYED = "folder_files.played_at <= queue.created_at";
	}

	public class ShuffleSessionIds {
		public static final @NonNull String TABLE = "shuffle_session_ids";

		public static final @NonNull String _ID = TABLE + "._id";
	}


	public class EqPresets {
		public static final @NonNull String TABLE = "eq_presets";

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Predefined preset number (see res/values/arrays/eq_preset_labels) or NULL for custom preset.
		 * Int.
		 */
		public static final @NonNull String PRESET = "preset";

		/*
		 * Eq preset string.
		 * String. 
		 */
		public static final @NonNull String _DATA = TABLE + "._data";

		/*
		 * Custom preset name or null for predefined preset.
		 * String.
		 */
		public static final @NonNull String NAME = TABLE + ".name";

		/*
		 * 1 if preset is bound to speaker, 0 otherwise.
		 * Int.
		 */
		public static final @NonNull String BIND_TO_SPEAKER = "bind_to_speaker";

		/*
		 * 1 if preset is bound to wired headset, 0 otherwise.
		 * Int.
		 */
		public static final @NonNull String BIND_TO_WIRED = "bind_to_wired";

		/*
		 * 1 if preset is bound to bluetooth audio output, 0 otherwise.
		 * Int.
		 */
		public static final @NonNull String BIND_TO_BT = "bind_to_bt";
		
		/*
		 * 1 if preset is bound to USB audio output, 0 otherwise.
		 * Int.
		 */
		public static final @NonNull String BIND_TO_USB = "bind_to_usb";
		
		/*
		 * 1 if preset is bound to other audio outputs, 0 otherwise.
		 * Int.
		 */
		public static final @NonNull String BIND_TO_OTHER = "bind_to_other";
	}
	
	/**
	 * Same as EqPresets, but can be used for INSERT
	 */
	public static final class EqPresetsRaw extends EqPresets {
		@SuppressWarnings("hiding")
		public static final @NonNull String _ID = "_id";
		@SuppressWarnings("hiding")
		public static final @NonNull String _DATA = "_data";
		@SuppressWarnings("hiding")
		public static final @NonNull String NAME = "name";
	}

	/**
	 * @deprecated Not used now
	 */
	@Deprecated
	public static final class EqPresetSongs implements BaseColumns {
		public static final @NonNull String TABLE = "eq_preset_songs";

		public static final @NonNull String _ID = TABLE + "._id";

		/*
		 * Either folder_file_id.
		 * Int. 
		 */
		public static final @NonNull String FILE_ID = TABLE + ".file_id";

		/*
		 * Eq preset id.
		 * Int.
		 */
		public static final @NonNull String PRESET_ID = "preset_id";
	}

	public class ReverbPresets {
		public static final @NonNull String TABLE = "reverb_presets";

		public static final @NonNull String _ID = TABLE + "._id";

		public static final @NonNull String _DATA = TABLE + "._data";

		public static final @NonNull String NAME = TABLE + ".name";
	}

	/**
	 * Same as ReverbPresets, but can be used for INSERT
	 */
	public class ReverbPresetsRaw extends ReverbPresets {
		@SuppressWarnings("hiding")
		public static final @NonNull String _ID = "_id";
		@SuppressWarnings("hiding")
		public static final @NonNull String _DATA = "_data";
		@SuppressWarnings("hiding")
		public static final @NonNull String NAME = "name";
	}

}
