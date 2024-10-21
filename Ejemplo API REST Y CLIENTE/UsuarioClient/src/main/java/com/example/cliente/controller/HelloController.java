package com.example.cliente.controller;

import com.example.cliente.model.Usuario;
import com.example.cliente.service.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HelloController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId; // Para seleccionar el ID de usuario a actualizar o eliminar

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnObtener;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<Usuario> tblUsuarios;

    @FXML
    private TableColumn<Usuario, String> tblColumNombre;

    @FXML
    private TableColumn<Usuario, String> tblColEmail;

    @FXML
    private TableColumn<Usuario, Long> tblColumId;

    private final UsuarioService usuarioService = new UsuarioService();
    private final ObservableList<Usuario> usuarioList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configurarColumnasTabla();
        configurarAnchoColumnas();
        tblUsuarios.setItems(usuarioList);
    }

    @FXML
    public void onHelloButtonClick() {
        cargarUsuariosEnTabla();
    }

    @FXML
    public void registrarUsuario() {
        if (!validarCampos()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return;
        }

        Usuario usuario = new Usuario(txtNombre.getText(), txtEmail.getText());

        try {
            usuarioService.guardarUsuario(usuario);
            limpiarCampos();
            mostrarAlerta("Éxito", "Usuario registrado con éxito");
            cargarUsuariosEnTabla();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo registrar el usuario: " + e.getMessage());
        }
    }

    @FXML
    public void actualizarUsuario() {
        if (!validarCampos() || txtId.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos y el ID son obligatorios");
            return;
        }

        Long id = Long.parseLong(txtId.getText());
        Usuario usuarioActualizado = new Usuario(txtNombre.getText(), txtEmail.getText());

        try {
            usuarioService.actualizarUsuario(id, usuarioActualizado);
            limpiarCampos();
            mostrarAlerta("Éxito", "Usuario actualizado con éxito");
            cargarUsuariosEnTabla();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo actualizar el usuario: " + e.getMessage());
        }
    }

    @FXML
    public void eliminarUsuario() {
        if (txtId.getText().isEmpty()) {
            mostrarAlerta("Error", "El campo de ID es obligatorio para eliminar un usuario");
            return;
        }

        Long id = Long.parseLong(txtId.getText());

        try {
            usuarioService.eliminarUsuario(id);
            limpiarCampos();
            mostrarAlerta("Éxito", "Usuario eliminado con éxito");
            cargarUsuariosEnTabla();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo eliminar el usuario: " + e.getMessage());
        }
    }

    private void configurarColumnasTabla() {
        tblColumId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblColumNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tblColEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void configurarAnchoColumnas() {
        tblColumId.prefWidthProperty().bind(tblUsuarios.widthProperty().multiply(0.2)); // 20% para el ID
        tblColumNombre.prefWidthProperty().bind(tblUsuarios.widthProperty().multiply(0.4)); // 40% para el Nombre
        tblColEmail.prefWidthProperty().bind(tblUsuarios.widthProperty().multiply(0.4)); // 40% para el Email
    }

    private void cargarUsuariosEnTabla() {
        try {
            List<Usuario> usuarios = usuarioService.obtenerUsuarios();
            usuarioList.clear();
            usuarioList.addAll(usuarios);
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo obtener la lista de usuarios: " + e.getMessage());
        }
    }

    private boolean validarCampos() {
        return !txtNombre.getText().isEmpty() && !txtEmail.getText().isEmpty();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtEmail.clear();
        txtId.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
