/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolistapp;

/**
 *
 * @author Namo
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {
    private List<Task> tasks;

    public ToDoListApp() {
        tasks = new ArrayList<>();
    }

    // Menambah tugas baru
    public void addTask(String title) {
        tasks.add(new Task(title));
        System.out.println("Tugas berhasil ditambahkan.");
    }

    // Mengedit tugas berdasarkan indeks
    public void editTask(int index, String newTitle) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setTitle(newTitle);
            System.out.println("Tugas berhasil diedit.");
        } else {
            System.out.println("Tugas tidak ditemukan.");
        }
    }

    // Menghapus tugas berdasarkan indeks
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Tugas berhasil dihapus.");
        } else {
            System.out.println("Tugas tidak ditemukan.");
        }
    }

    // Menandai tugas sebagai selesai
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("Tugas berhasil ditandai sebagai selesai.");
        } else {
            System.out.println("Tugas tidak ditemukan.");
        }
    }

    public List<Task> getTasks() {
    return tasks;
}
    // Menampilkan semua tugas
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Tidak ada tugas yang tersedia.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ": " + tasks.get(i));
            }
        }
    }

    // Mencari tugas berdasarkan kata kunci
    public void searchTasks(String keyword) {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(i + ": " + tasks.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tugas dengan kata kunci '" + keyword + "' tidak ditemukan.");
        }
    }

    // Filter tugas yang sudah selesai
    public void filterCompletedTasks() {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isCompleted()) {
                System.out.println(i + ": " + tasks.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada tugas yang sudah selesai.");
        }
    }
    

    // Main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nPerintah: add, edit, delete, complete, list, search, filter, exit");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.print("Masukkan judul tugas: ");
                    String title = scanner.nextLine();
                    app.addTask(title);
                    break;
                case "edit":
                    System.out.print("Masukkan indeks tugas yang ingin diedit: ");
                    int editIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan judul baru: ");
                    String newTitle = scanner.nextLine();
                    app.editTask(editIndex, newTitle);
                    break;
                case "delete":
                    System.out.print("Masukkan indeks tugas yang ingin dihapus: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    app.deleteTask(deleteIndex);
                    break;
                case "complete":
                    System.out.print("Masukkan indeks tugas yang sudah selesai: ");
                    int completeIndex = Integer.parseInt(scanner.nextLine());
                    app.markTaskAsCompleted(completeIndex);
                    break;
                case "list":
                    app.displayTasks();
                    break;
                case "search":
                    System.out.print("Masukkan kata kunci pencarian: ");
                    String keyword = scanner.nextLine();
                    app.searchTasks(keyword);
                    break;
                case "filter":
                    app.filterCompletedTasks();
                    break;
                case "exit":
                    System.out.println("Keluar dari aplikasi.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Perintah tidak dikenali.");
            }
        }
    }
}
