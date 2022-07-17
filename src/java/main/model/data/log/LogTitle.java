package main.model.data.log;

public enum LogTitle {
    CREATED {
      public String toString() { return "Created"; }
    },
    EDITED {
        public String toString() { return "Edited"; }
    },
    ADDED_TO_FAV {
        public String toString() { return "Added to Favourites"; }
    },
    REMOVED_FROM_FAV {
        public String toString() { return "Removed from Favourites"; }
    },
    DELETED {
        public String toString() { return "Deleted"; }
    }
}
