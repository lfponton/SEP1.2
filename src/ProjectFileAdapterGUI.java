import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A user interface that allows for displaying and modifying information about projects.
 *
 * @author Luis Fernandez
 * @version 1.0
 */

public class ProjectFileAdapterGUI extends Application
{
  private ProjectFileAdapter adapter;

  private VBox mainPane;

  private TabPane tabPane;

  // Projects Tab
  private Tab projectTab;
  private VBox projectPane;
  private HBox projectTopPane;
  private FlowPane projectTablePane;

  private Label projectIdLabel;
  private Label projectTitleLabel;
  private Label projectDescriptionLabel;

  private GridPane projectInputPane;

  private TableView<Project> allProjectsTable;
  private TableView.TableViewSelectionModel<Project> projectsDefaultSelectionModel;
  private TableColumn<Project, String> projectIdColumn;
  private TableColumn<Project, String> projectTitleColumn;
  private TableColumn<Project, String> projectDescriptionColumn;

  private TextField projectIdField;
  private TextField projectTitleField;
  private TextField projectDescriptionField;

  private Button projectCreateButton;

  private HBox selectedProjectPane;
  private Label selectedProjectIdLabel;
  private Label selectedProjectIdOutput;

  // Requirements Tab
  private Tab reqTab;
  private VBox reqPane;
  private HBox reqTopPane;
  private FlowPane reqTablePane;

  private Label reqIdLabel;
  private Label reqProjectIdLabel;
  private Label reqDescriptionLabel;
  private Label reqStatusLabel;
  private Label reqTotalHoursLabel;
  private Label reqTimeEstimateLabel;
  private Label reqDeadlineLabel;
  private Label reqDayLabel;
  private Label reqMonthLabel;
  private Label reqYearLabel;
  private Label reqTeamMemberLabel;

  private GridPane reqInputPane;

  private TableView<Requirement> allReqsTable;
  private TableView.TableViewSelectionModel<Requirement> reqDefaultSelectionModel;
  private TableColumn<Requirement, String> reqIdColumn;
  private TableColumn<Requirement, String> reqStatusColumn;
  private TableColumn<Requirement, String> reqDescriptionColumn;
  private TableColumn<Requirement, String> reqTotalHoursColumn;
  private TableColumn<Requirement, String> reqTimeEstimateColumn;
  private TableColumn<Requirement, String> reqDeadlineColumn;
  private TableColumn<Requirement, String> reqTeamMemberColumn;

  private TextField reqIdField;
  private TextField reqProjectIdField;
  private TextField reqDescriptionField;
  private TextField reqStatusField;
  private TextField reqTotalHoursField;
  private TextField reqTimeEstimateField;
  private TextField reqDayField;
  private TextField reqMonthField;
  private TextField reqYearField;
  private TextField reqTeamMemberField;

  private FlowPane imagePane;
  private Image logo;
  private ImageView logoView;

  private Button reqCreateButton;

  // Tasks Tab
  private Tab taskTab;
  private VBox taskPane;
  private HBox taskTopPane;
  private FlowPane taskTablePane;

  private Label taskIdLabel;
  private Label taskProjectIdLabel;
  private Label taskReqIdLabel;
  private Label taskDescriptionLabel;
  private Label taskStatusLabel;
  private Label taskTotalHoursLabel;
  private Label taskTimeEstimateLabel;
  private Label taskDeadlineLabel;
  private Label taskDayLabel;
  private Label taskMonthLabel;
  private Label taskYearLabel;
  private Label taskTeamMemberLabel;

  private GridPane taskInputPane;

  private TableView<Task> allTasksTable;
  private TableView.TableViewSelectionModel<Task> taskDefaultSelectionModel;
  private TableColumn<Task, String> taskIdColumn;
  private TableColumn<Task, String> taskStatusColumn;
  private TableColumn<Task, String> taskDescriptionColumn;
  private TableColumn<Task, String> taskTotalHoursColumn;
  private TableColumn<Task, String> taskTimeEstimateColumn;
  private TableColumn<Task, String> taskDeadlineColumn;
  private TableColumn<Task, String> taskTeamMemberColumn;

  private TextField taskIdField;
  private TextField taskProjectIdField;
  private TextField taskDescriptionField;
  private TextField taskReqIdField;
  private TextField taskStatusField;
  private TextField taskTotalHoursField;
  private TextField taskTimeEstimateField;
  private TextField taskDeadlineField;
  private TextField taskDayField;
  private TextField taskMonthField;
  private TextField taskYearField;
  private TextField taskTeamMemberField;

  private Button taskCreateButton;

  // Employees Tab

  private EmployeeFileAdapter employeeAdapter;

  private Tab employeeTab;

  private HBox employeeTopPane;
  private FlowPane employeeTablePane;

  private Label firstNameLabel;
  private Label lastNameLabel;
  private Label roleLabel;

  private GridPane employeeInputPane;

  private TableView<Employee> allEmployeeTable;
  private TableView.TableViewSelectionModel<Employee> employeeDefaultSelectionModel;
  private TableColumn<Employee, String> firstNameColumn;
  private TableColumn<Employee, String> lastNameColumn;
  private TableColumn<Employee, String> roleColumn;

  private TextField firstNameField;
  private TextField lastNameField;
  private TextField roleField;

  private Tab editEmployeeTab;
  private Tab allEmployeeTab;
  private Tab editAreaMenuItem;

  private TextArea allEmployeeArea;

  private Button getButton;
  private Button employeeCreateButton;
  private Button updateButton;

  private ComboBox<Employee> employeeBox;
  private VBox employeePane;

  // Menu
  private MenuBar menuBar;

  private Menu fileMenu;
  private Menu aboutMenu;

  private MenuItem exitMenuItem;
  private MenuItem aboutMenuItem;

  private CheckMenuItem editTableMenuItem;
  private CheckMenuItem editFieldsMenuItem;

  private MyActionListener listener;
  private MyTabListener tabListener;
  private MyListListener tableListener;

  /**
   * @param window The Stage object that will be displayed
   */
  public void start(Stage window)
  {
    window.setTitle("ColourIT Project Manager");

    String projectsFile = "C:\\Users\\lfpon\\IdeaProjects\\SEP1.2\\projects.bin";
    String employeesFile = "C:\\Users\\lfpon\\IdeaProjects\\SEP1.2\\employees.bin";

    adapter = new ProjectFileAdapter(projectsFile);
    employeeAdapter = new EmployeeFileAdapter(employeesFile);
    listener = new MyActionListener();
    tabListener = new MyTabListener();
    tableListener = new MyListListener();

    tabPane = new TabPane();
    tabPane.getSelectionModel().selectedItemProperty().addListener(tabListener);

    // Projects Tab
    projectCreateButton = new Button("Create");
    projectCreateButton.setOnAction(listener);

    projectPane = new VBox(20);
    projectPane.setPadding(new Insets(10));

    projectTopPane = new HBox(20);

    allProjectsTable = new TableView<Project>();
    projectsDefaultSelectionModel = allProjectsTable.getSelectionModel();
    allProjectsTable.setPrefHeight(290);

    projectIdColumn = new TableColumn<Project, String>("Project ID");
    projectIdColumn
        .setCellValueFactory(new PropertyValueFactory<Project, String>("id"));
    projectIdColumn.setPrefWidth(165);

    projectTitleColumn = new TableColumn<Project, String>("Title");
    projectTitleColumn.setCellValueFactory(
        new PropertyValueFactory<Project, String>("title"));
    projectTitleColumn.setPrefWidth(165);

    projectDescriptionColumn = new TableColumn<Project, String>("Description");
    projectDescriptionColumn.setCellValueFactory(
        new PropertyValueFactory<Project, String>("description"));
    projectDescriptionColumn.setPrefWidth(165);

    allProjectsTable.getColumns().add(projectIdColumn);
    allProjectsTable.getColumns().add(projectTitleColumn);
    allProjectsTable.getColumns().add(projectDescriptionColumn);
    allProjectsTable.getSelectionModel().selectedItemProperty()
        .addListener((tableListener));

    projectTablePane = new FlowPane();
    projectTablePane.setAlignment(Pos.BASELINE_RIGHT);
    projectTablePane.setPrefWidth(200);
    projectTablePane.getChildren().add(allProjectsTable);

    projectIdLabel = new Label("Project ID:");
    projectTitleLabel = new Label("Title:");
    projectDescriptionLabel = new Label("Description:");

    projectIdField = new TextField();
    projectTitleField = new TextField();
    projectDescriptionField = new TextField();

    projectInputPane = new GridPane();
    projectInputPane.setHgap(5);
    projectInputPane.setVgap(5);
    projectInputPane.addRow(0, projectIdLabel, projectIdField);
    projectInputPane.addRow(1, projectTitleLabel, projectTitleField);
    projectInputPane
        .addRow(2, projectDescriptionLabel, projectDescriptionField);

    projectTopPane.getChildren().add(projectInputPane);
    projectTopPane.getChildren().add(allProjectsTable);
/*
    logo = new Image("file:img/vialogoah.gif");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);
*/
    selectedProjectPane = new HBox(20);
    selectedProjectIdLabel = new Label("Selected Project:");
    selectedProjectIdOutput = new Label();
    selectedProjectPane.getChildren()
        .addAll(selectedProjectIdLabel, selectedProjectIdOutput);

    projectPane.getChildren().add(selectedProjectPane);
    projectPane.getChildren().add(projectTopPane);
    projectPane.getChildren().add(projectCreateButton);

    //projectPane.getChildren().add(imagePane);
    projectTab = new Tab("Projects");
    projectTab.setContent(projectPane);

    // Requirements Tab
    reqCreateButton = new Button("Create");
    reqCreateButton.setOnAction(listener);

    reqPane = new VBox(20);
    reqPane.setPadding(new Insets(10));

    reqTopPane = new HBox(20);

    allReqsTable = new TableView<Requirement>();
    reqDefaultSelectionModel = allReqsTable.getSelectionModel();
    allReqsTable.setPrefHeight(290);

    reqIdColumn = new TableColumn<Requirement, String>("Requirement ID");
    reqIdColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("id"));
    reqIdColumn.setPrefWidth(165);

    reqStatusColumn = new TableColumn<Requirement, String>("Status");
    reqStatusColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("Status"));
    reqStatusColumn.setPrefWidth(165);

    reqDescriptionColumn = new TableColumn<Requirement, String>("Description");
    reqDescriptionColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("Description"));
    reqDescriptionColumn.setPrefWidth(165);

    reqDeadlineColumn = new TableColumn<Requirement, String>("Deadline");
    reqDeadlineColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("Deadline"));
    reqDeadlineColumn.setPrefWidth(165);

    allReqsTable.getColumns().add(reqIdColumn);
    allReqsTable.getColumns().add(reqStatusColumn);
    allReqsTable.getColumns().add(reqDescriptionColumn);
    allReqsTable.getColumns().add(reqDeadlineColumn);

    reqTablePane = new FlowPane();
    reqTablePane.setAlignment(Pos.BASELINE_RIGHT);
    reqTablePane.setPrefWidth(200);
    reqTablePane.getChildren().add(allReqsTable);

    reqIdLabel = new Label("Requirement ID:");
    reqStatusLabel = new Label("Status:");
    reqDescriptionLabel = new Label("Description:");
    reqDayLabel = new Label("Day");
    reqMonthLabel = new Label("Month");
    reqYearLabel = new Label("Year");

    reqIdField = new TextField();
    reqStatusField = new TextField();
    reqDescriptionField = new TextField();
    reqDayField = new TextField();
    reqMonthField = new TextField();
    reqYearField = new TextField();

    reqInputPane = new GridPane();
    reqInputPane.setHgap(5);
    reqInputPane.setVgap(5);
    reqInputPane.addRow(0, reqIdLabel, reqIdField);
    reqInputPane.addRow(1, reqStatusLabel, reqStatusField);
    reqInputPane.addRow(2, reqDescriptionLabel, reqDescriptionField);
    reqInputPane.addRow(3, reqDayLabel, reqDayField);
    reqInputPane.addRow(4, reqMonthLabel, reqMonthField);
    reqInputPane.addRow(5, reqYearLabel, reqYearField);

    reqTopPane.getChildren().add(reqInputPane);
    reqTopPane.getChildren().add(allReqsTable);
/*
    logo = new Image("file:img/vialogoah.gif");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);
*/
    reqPane.getChildren().add(reqTopPane);
    reqPane.getChildren().add(reqCreateButton);

    //projectPane.getChildren().add(imagePane);

    reqTab = new Tab("Requirements");
    reqTab.setContent(reqPane);

    // Tasks Tab

    taskCreateButton = new Button("Create");
    taskCreateButton.setOnAction(listener);

    taskPane = new VBox(20);
    taskPane.setPadding(new Insets(10));

    taskTopPane = new HBox(20);

    allTasksTable = new TableView<Task>();
    taskDefaultSelectionModel = allTasksTable.getSelectionModel();
    allTasksTable.setPrefHeight(290);

    taskIdColumn = new TableColumn<Task, String>("Task ID");
    taskIdColumn
        .setCellValueFactory(new PropertyValueFactory<Task, String>("id"));
    taskIdColumn.setPrefWidth(165);

    taskStatusColumn = new TableColumn<Task, String>("Status");
    taskStatusColumn
        .setCellValueFactory(new PropertyValueFactory<Task, String>("Status"));
    taskStatusColumn.setPrefWidth(165);

    taskDescriptionColumn = new TableColumn<Task, String>("Description");
    taskDescriptionColumn.setCellValueFactory(
        new PropertyValueFactory<Task, String>("Description"));
    taskDescriptionColumn.setPrefWidth(165);

    allTasksTable.getColumns().add(taskIdColumn);
    allTasksTable.getColumns().add(taskStatusColumn);
    allTasksTable.getColumns().add(taskDescriptionColumn);

    taskTablePane = new FlowPane();
    taskTablePane.setAlignment(Pos.BASELINE_RIGHT);
    taskTablePane.setPrefWidth(200);
    taskTablePane.getChildren().add(allTasksTable);

    taskIdLabel = new Label("Task ID:");
    taskStatusLabel = new Label("Status:");
    taskDescriptionLabel = new Label("Description:");

    taskIdField = new TextField();
    taskStatusField = new TextField();
    taskDescriptionField = new TextField();

    taskInputPane = new GridPane();
    taskInputPane.setHgap(5);
    taskInputPane.setVgap(5);
    taskInputPane.addRow(0, taskIdLabel, taskIdField);
    taskInputPane.addRow(1, taskStatusLabel, taskStatusField);
    taskInputPane.addRow(2, taskDescriptionLabel, taskDescriptionField);

    taskTopPane.getChildren().add(taskInputPane);
    taskTopPane.getChildren().add(allTasksTable);
/*
    logo = new Image("file:img/vialogoah.gif");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);
*/
    taskPane.getChildren().add(taskTopPane);
    taskPane.getChildren().add(taskCreateButton);

    //projectPane.getChildren().add(imagePane);

    taskTab = new Tab("Task");
    taskTab.setContent(taskPane);

    // Employees

    employeeCreateButton = new Button("Create");
    employeeCreateButton.setOnAction(listener);

    employeePane = new VBox(20);
    employeePane.setPadding(new Insets(10));

    employeeTopPane = new HBox(20);

    allEmployeeTable = new TableView<Employee>();
    employeeDefaultSelectionModel = allEmployeeTable.getSelectionModel();
    allEmployeeTable.setPrefHeight(290);

    firstNameColumn = new TableColumn<Employee, String>("First name");
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
    firstNameColumn.setPrefWidth(165);

    lastNameColumn = new TableColumn<Employee, String>("Last name");
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
    lastNameColumn.setPrefWidth(165);

    roleColumn = new TableColumn<Employee, String>("Role");
    roleColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
    roleColumn.setPrefWidth(165);

    allEmployeeTable.getColumns().add(firstNameColumn);
    allEmployeeTable.getColumns().add(lastNameColumn);
    allEmployeeTable.getColumns().add(roleColumn);

    employeeTablePane = new FlowPane();
    employeeTablePane.setAlignment(Pos.BASELINE_RIGHT);
    employeeTablePane.setPrefWidth(200);
    employeeTablePane.getChildren().add(allEmployeeTable);

    firstNameLabel = new Label("First name:");
    lastNameLabel = new Label("Last name:");
    roleLabel = new Label("Role:");

    firstNameField = new TextField();
    lastNameField = new TextField();
    roleField = new TextField();

    employeeInputPane = new GridPane();
    employeeInputPane.setHgap(5);
    employeeInputPane.setVgap(5);
    employeeInputPane.addRow(0, firstNameLabel, firstNameField);
    employeeInputPane.addRow(1, lastNameLabel, lastNameField);
    employeeInputPane.addRow(2, roleLabel, roleField);

    employeeTopPane.getChildren().add(employeeInputPane);
    employeeTopPane.getChildren().add(allEmployeeTable);
/*
    logo = new Image("file:img/vialogoah.gif");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);
*/
    employeePane.getChildren().add(employeeTopPane);
    employeePane.getChildren().add(employeeCreateButton);

    //employeePane.getChildren().add(imagePane);
    employeeTab = new Tab("Employees");
    employeeTab.setContent(employeePane);

    // Tabs
    tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
    tabPane.getTabs().add(projectTab);
    tabPane.getTabs().add(reqTab);
    tabPane.getTabs().add(taskTab);
    tabPane.getTabs().add(employeeTab);

    exitMenuItem = new MenuItem("Exit");
    exitMenuItem.setOnAction(listener);

    aboutMenuItem = new MenuItem("About");
    aboutMenuItem.setOnAction(listener);

    editTableMenuItem = new CheckMenuItem("Select in student table");
    editTableMenuItem.setSelected(true);
    editTableMenuItem.setOnAction(listener);

    editFieldsMenuItem = new CheckMenuItem("Edit name fields");
    editFieldsMenuItem.setOnAction(listener);

    fileMenu = new Menu("File");
    aboutMenu = new Menu("About");

    fileMenu.getItems().add(exitMenuItem);

    aboutMenu.getItems().add(aboutMenuItem);

    menuBar = new MenuBar();

    menuBar.getMenus().add(fileMenu);
    menuBar.getMenus().add(aboutMenu);

    mainPane = new VBox();
    mainPane.getChildren().add(menuBar);
    mainPane.getChildren().add(tabPane);

    Scene scene = new Scene(mainPane, 1200, 600);

    window.setScene(scene);
    window.setResizable(false);
    window.show();
  }


  /**
   * Updates the allProjectsTable with information from the projects file
   */
  public void updateProjectsTable()
  {
    int currentIndex = allProjectsTable.getSelectionModel().getSelectedIndex();

    allProjectsTable.getItems().clear();

    ProjectList projects = adapter.getAllProjects();
    for (int i = 0; i < projects.size(); i++)
    {
      allProjectsTable.getItems().add(projects.getProject(i));
    }

    if (currentIndex == -1 && allProjectsTable.getItems().size() > 0)
    {
      allProjectsTable.getSelectionModel().select(0);
    }
    else
    {
      allProjectsTable.getSelectionModel().select(currentIndex);
    }
  }

  public void updateReqTable()
  {
    int currentIndex = allReqsTable.getSelectionModel().getSelectedIndex();

    allReqsTable.getItems().clear();

    String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
        .getId();

    RequirementList requirements = adapter.getAllRequirements(projectId);
    for (int i = 0; i < requirements.size(); i++)
    {
      allReqsTable.getItems().add(requirements.getRequirement(i));
    }

    if (currentIndex == -1 && allReqsTable.getItems().size() > 0)
    {
      allReqsTable.getSelectionModel().select(0);
    }
    else
    {
      allReqsTable.getSelectionModel().select(currentIndex);
    }

  }

  public void updateTaskTable()
  {
    int currentIndex = allTasksTable.getSelectionModel().getSelectedIndex();

    allTasksTable.getItems().clear();

    String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
        .getId();
    String reqId = allReqsTable.getSelectionModel().getSelectedItem().getId();

    TaskList tasks = adapter.getAllTasks(projectId, reqId);
    if (tasks != null)
    {
      for (int i = 0; i < tasks.size(); i++)
      {
        allTasksTable.getItems().add(tasks.getTask(i));
      }
    }

    if (currentIndex == -1 && allTasksTable.getItems().size() > 0)
    {
      allTasksTable.getSelectionModel().select(0);
    }
    else
    {
      allTasksTable.getSelectionModel().select(currentIndex);
    }
  }

  public void updateEmployeeTable()
  {
    int currentIndex = allEmployeeTable.getSelectionModel().getSelectedIndex();

    allEmployeeTable.getItems().clear();

    EmployeeList employee = employeeAdapter.getAllEmployees();
    for (int i = 0; i < employee.size(); i++)
    {
      allEmployeeTable.getItems().add(employee.getEmployee(i));
    }

    if (currentIndex == -1 && allEmployeeTable.getItems().size() > 0)
    {
      allEmployeeTable.getSelectionModel().select(0);
    }
    else
    {
      allEmployeeTable.getSelectionModel().select(currentIndex);
    }
  }


  public void updateSelectedProject()
  {
    if (allProjectsTable.getSelectionModel().getSelectedItem() != null)
    {
      String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
          .getId();
      selectedProjectIdOutput.setText(projectId);
    }
  }

  /*
   * Inner action listener class
   * @author Luis Fernandez
   * @version 1.0
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if (e.getSource() == exitMenuItem)
      {
        Alert alert = new Alert(AlertType.CONFIRMATION,
            "Do you really want to exit the program?", ButtonType.YES,
            ButtonType.NO);
        alert.setTitle("Exit");
        alert.setHeaderText(null);

        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES)
        {
          System.exit(0);
        }
      }

      else if (e.getSource() == aboutMenuItem)
      {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("ColourIT Project Manager.");
        alert.showAndWait();
      }

      else if (e.getSource() == projectCreateButton)
      {
        String id = projectIdField.getText();
        String title = projectTitleField.getText();
        String description = projectDescriptionField.getText();

        if (description.equals(""))
        {
          description = "?";
        }

        Project project = new Project(id, title, description);

        adapter.addProject(project);
        updateProjectsTable();
        projectIdField.setText("");
        projectTitleField.setText("");
        projectDescriptionField.setText("");
      }

      else if (e.getSource() == reqCreateButton)
      {
        String id = reqIdField.getText();
        String status = reqStatusField.getText();
        String description = reqDescriptionField.getText();
        int day = Integer.parseInt(reqDayField.getText());
        int month = Integer.parseInt(reqMonthField.getText());
        int year = Integer.parseInt(reqYearField.getText());

        Date deadline = new Date(day, month, year);

        if (description.equals(""))
        {
          description = "?";
        }

        Requirement requirement = new Requirement(id, status, description,
            deadline);
        String projectId = allProjectsTable.getSelectionModel()
            .getSelectedItem().getId();

        adapter.addRequirement(projectId, requirement);
        updateReqTable();
        reqIdField.setText("");
        reqStatusField.setText("");
        reqDescriptionField.setText("");
        reqDayField.setText("");
        reqMonthField.setText("");
        reqYearField.setText("");
      }

      else if (e.getSource() == taskCreateButton)
      {
        String id = taskIdField.getText();
        String status = taskStatusField.getText();
        String description = taskDescriptionField.getText();

        if (description.equals(""))
        {
          description = "?";
        }

        Task task = new Task(id, status, description);
        String projectId = allProjectsTable.getSelectionModel()
            .getSelectedItem().getId();
        String reqId = allReqsTable.getSelectionModel().getSelectedItem()
            .getId();

        adapter.addTask(projectId, reqId, task);
        updateTaskTable();
        taskIdField.setText("");
        taskStatusField.setText("");
        taskDescriptionField.setText("");
      }

      else if (e.getSource() == employeeCreateButton)
      {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String role = roleField.getText();

        if (role.equals(""))
        {
          role = "?";
        }

        Employee employee = new Employee(firstName, lastName, role);

        employeeAdapter.addEmployee(employee);
        updateEmployeeTable();
        firstNameField.setText("");
        lastNameField.setText("");
        roleField.setText("");
      }

    }
  }

  /*
   * Inner change listener class
   * @author Luis Fernandez
   * @version 1.0
   */
  private class MyTabListener implements ChangeListener<Tab>
  {
    public void changed(ObservableValue<? extends Tab> tab, Tab oldTab,
        Tab newTab)
    {
      if (newTab == projectTab)
      {
        updateProjectsTable();
        updateSelectedProject();
      }
      else if (newTab == reqTab)
      {
        if (allReqsTable.getSelectionModel().getSelectedItem() != null)
        {
          updateReqTable();
        }
      }
      else if (newTab == taskTab)
      {
        if (allReqsTable.getSelectionModel().getSelectedItem() != null)
        {
          updateTaskTable();
        }
      }
      else if (newTab == employeeTab)
      {
        updateEmployeeTable();
      }

    }
  }

  private class MyListListener implements ChangeListener<Project>
  {
    public void changed(ObservableValue<? extends Project> project,
        Project oldProject, Project newProject)
    {
      Project temp = allProjectsTable.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        updateSelectedProject();
        /*
        projectIdField.setText(temp.getId());
        projectTitleField.setText(temp.getTitle());
        projectDescriptionField.setPromptText(temp.getDescription());
         */
      }
    }

    public void changed(ObservableValue<? extends Requirement> requirement,
        Requirement oldRequirement, Requirement newRequirement)
    {
      Requirement temp = allReqsTable.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        reqIdField.setText(temp.getId());
        reqStatusField.setText(temp.getStatus());
        reqDescriptionField.setText(temp.getDescription());
      }
    }

    public void changed(ObservableValue<? extends Task> task, Task oldTask,
        Task newTask)
    {
      Task temp = allTasksTable.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        taskIdField.setText(temp.getId());
        taskStatusField.setText(temp.getStatus());
        taskDescriptionField.setPromptText(temp.getDescription());
      }
    }
  }
}

