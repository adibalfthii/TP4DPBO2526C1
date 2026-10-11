package icip_java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PeopleMenu extends JFrame {
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField tahunLahirField;
    private JTextField kategoriField;
    private JComboBox<String> statusComboBox;
    private JTable tablePerson;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;

    private ArrayList<Person> listPerson;
    private DefaultTableModel tableModel;
    private int selectedIndex = -1;

    public PeopleMenu() {
        setContentPane(mainPanel);
        setTitle("PeopleData - UTS DPBO");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listPerson = new ArrayList<>();
        setupTable();
        populateInitialData();

        // Mengisi pilihan ComboBox Status
        statusComboBox.addItem("Aktif");
        statusComboBox.addItem("Cuti");
        statusComboBox.addItem("Non-Aktif");

        // Tombol Add
        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String nama = namaField.getText().trim();
            String tahunLahir = tahunLahirField.getText().trim();
            String kategori = kategoriField.getText().trim();
            String status = (String) statusComboBox.getSelectedItem();

            if (id.isEmpty() || nama.isEmpty() || tahunLahir.isEmpty() || kategori.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                return;
            }

            listPerson.add(new Person(id, nama, tahunLahir, kategori, status));
            updateTable();
            clearForm();
        });

        // Tombol Update
        updateButton.addActionListener(e -> {
            if (selectedIndex >= 0) {
                Person p = listPerson.get(selectedIndex);
                p.setId(idField.getText().trim());
                p.setNama(namaField.getText().trim());
                p.setTahunLahir(tahunLahirField.getText().trim());
                p.setKategori(kategoriField.getText().trim());
                p.setStatus((String) statusComboBox.getSelectedItem());

                updateTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris pada tabel yang ingin di-update!");
            }
        });

        // Tombol Delete 
        deleteButton.addActionListener(e -> {
            int selectedRow = tablePerson.getSelectedRow();
            if (selectedRow >= 0) {
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Apakah anda yakin akan menghapus data person ini?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    listPerson.remove(selectedRow);
                    updateTable();
                    clearForm();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris pada tabel yang ingin dihapus!");
            }
        });

        // Tombol Cancel
        cancelButton.addActionListener(e -> clearForm());

        // Klik tabel untuk memilih data
        tablePerson.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedIndex = tablePerson.getSelectedRow();
                if (selectedIndex >= 0) {
                    Person p = listPerson.get(selectedIndex);
                    idField.setText(p.getId());
                    namaField.setText(p.getNama());
                    tahunLahirField.setText(p.getTahunLahir());
                    kategoriField.setText(p.getKategori());
                    statusComboBox.setSelectedItem(p.getStatus());
                }
            }
        });
    }

    private void setupTable() {
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama", "Tahun Lahir", "Kategori", "Status"}, 0);
        tablePerson.setModel(tableModel);
    }

    private void populateInitialData() {
        listPerson.add(new Person("P001", "Budi Santoso", "1998", "Karyawan", "Aktif"));
        listPerson.add(new Person("P002", "Siti Aminah", "2000", "Karyawan", "Cuti"));
        updateTable();
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Person p : listPerson) {
            tableModel.addRow(new Object[]{p.getId(), p.getNama(), p.getTahunLahir(), p.getKategori(), p.getStatus()});
        }
    }

    private void clearForm() {
        idField.setText("");
        namaField.setText("");
        tahunLahirField.setText("");
        kategoriField.setText("");
        statusComboBox.setSelectedIndex(0);
        selectedIndex = -1;
        tablePerson.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PeopleMenu().setVisible(true));
    }
}