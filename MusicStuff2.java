public class MusicStuff2 {
    public static int turn = 1;

    public static void main(String[] args) throws Exception {

        FilePlayer player = new FilePlayer();
        Object lock = new Object();
        String[] song = {
                "do","do","sol","sol","la","la","sol","fa","fa","mi","mi","re","re","do",
                "sol","sol","fa","fa","mi","mi","re","sol","sol","fa","fa","mi","mi","re",
                "do","do","sol","sol","la","la","sol","fa","fa","mi","mi","re","re","do"
        };
        String[] thread1Notes = filterNotes(song, new String[]{"do", "mi", "sol", "si", "do-octave"});
        String[] thread2Notes = filterNotes(song, new String[]{"re", "fa", "la", "do-octave"});
        Thread t1 = new NotePlayerThread(1, thread1Notes, player, lock);
        Thread t2 = new NotePlayerThread(2, thread2Notes, player, lock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Song finished!");
    }
    public static String[] filterNotes(String[] song, String[] allowed) {

        java.util.List<String> list = new java.util.ArrayList<>();

        for (String note : song) {
            for (String a : allowed) {
                if (note.equals(a)) {
                    list.add(note);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}

