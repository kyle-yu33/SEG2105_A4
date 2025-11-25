public class NotePlayerThread extends Thread {

    private final String[] notes;
    private final FilePlayer player;
    private final Object lock;
    private final int threadId; 

    public NotePlayerThread(int threadId, String[] notes, FilePlayer player, Object lock) {
        this.threadId = threadId;
        this.notes = notes;
        this.player = player;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (String note : notes) {
            synchronized (lock) {
                try {
                    while (MusicStuff2.turn != threadId) {
                        lock.wait();
                    }
                    player.play("Multithreading Resources/Sounds/" + note + ".wav");
                    System.out.println("Thread " + threadId + " played: " + note);
                    Thread.sleep(400);
                    MusicStuff2.turn = (threadId == 1) ? 2 : 1;
                    lock.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
