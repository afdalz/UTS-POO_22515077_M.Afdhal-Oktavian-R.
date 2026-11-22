package restoran;
public class QueuePesanan {
    private Pesanan[] dataQueue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public QueuePesanan(int capacity) {
        this.capacity = capacity;
        this.dataQueue = new Pesanan[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(Pesanan pesanan) {
        if (isFull()) {
            System.out.println("Antrean Pesanan Penuh! Tidak dapat menambahkan pesanan baru.");
            return;
        }
        rear = (rear + 1) % capacity;
        dataQueue[rear] = pesanan;
        size++;
        System.out.println("Pesanan " + pesanan.getIdPesanan() + " berhasil dimasukkan ke dalam antrean.");
    }

    public Pesanan dequeue() {
        if (isEmpty()) {
            System.out.println("Antrean Pesanan Kosong!");
            return null;
        }
        Pesanan pesananKeluar = dataQueue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Pesanan " + pesananKeluar.getIdPesanan() + " diproses/dikeluarkan dari antrean.");
        return pesananKeluar;
    }

    public Pesanan front() {
        if (isEmpty()) {
            System.out.println("Antrean Kosong!");
            return null;
        }
        return dataQueue[front];
    }

    public int size() {
        return size;
    }

    public void tampilkanQueue() {
        System.out.println("=== ISI ANTREAN PESANAN (QUEUE) ===");
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }
        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". ID Pesanan: " + dataQueue[current].getIdPesanan() +
                    " | Total: Rp " + dataQueue[current].getTotalBiaya());
            current = (current + 1) % capacity;
        }
    }
}