import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
  private FlowPane imagePane;
  private Image logo;
  private ImageView logoView;

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
  private Button projectEditButton;
  private Button projectRemoveButton;

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
  private Label reqTMLabel;
   private Label reqPriorityLabel;
   private Label reqTypeLabel;

  private GridPane reqInputPane;

  private TableView<Requirement> allReqsTable;
  private TableView.TableViewSelectionModel<Requirement> reqDefaultSelectionModel;
  private TableColumn<Requirement, String> reqIdColumn;
  private TableColumn<Requirement, String> reqTypeColumn;
  private TableColumn<Requirement, String> reqPriorityColumn;
  private TableColumn<Requirement, String> reqStatusColumn;
  private TableColumn<Requirement, String> reqDescriptionColumn;
  private TableColumn<Requirement, String> reqTotalHoursColumn;
  private TableColumn<Requirement, String> reqTimeEstimateColumn;
  private TableColumn<Requirement, String> reqDeadlineColumn;
  private TableColumn<Requirement, String> reqTeamMemberColumn;

  private TextField reqIdField;
  private TextField reqProjectIdField;
  private TextField reqDescriptionField;
  private TextField reqTotalHoursField;
  private TextField reqTimeEstimateField;
  private TextField reqDayField;
  private TextField reqMonthField;
  private TextField reqYearField;

  private FlowPane imagePane;
  private Image logo;
  private ImageView logoView;

  private Button reqCreateButton;
  private Button reqEditButton;
  private Button reqRemoveButton;

  private HBox selectedReqPane;
  private HBox  reqButtomPane;
  private Label selectedReqProjectIdLabel;
  private Label selectedReqProjectIdOutput;
  private Label selectedReqIdLabel;
  private Label selectedReqIdOutput;

  private ComboBox<Employee> reqTMBox;
  private ComboBox<String> reqStatusBox;
  private ComboBox<String> reqPriorityBox;
  private ComboBox<String> reqTypeBox;

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
  private Button taskEditButton;
  private Button taskRemoveButton;

  private HBox selectedTaskPane;
  private Label selectedTaskProjectIdLabel;
  private Label selectedTaskProjectIdOutput;
  private Label selectedTaskReqIdLabel;
  private Label selectedTaskReqIdOutput;
  private Label selectedTaskIdLabel;
  private Label selectedTaskIdOutput;

  private ComboBox<Employee> taskTMBox;
  private ComboBox<String> taskStatusBox;

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

  private ComboBox<String> rolesStatusBox;

  private Tab editEmployeeTab;
  private Tab allEmployeeTab;
  private Tab editAreaMenuItem;

  private TextArea allEmployeeArea;

  private Button employeeEditButton;
  private Button employeeCreateButton;
  private Button employeeRemoveButton;

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
  private MyProjectListListener projectListener;
  private MyReqListListener reqListener;
  private MyTaskListListener taskListener;

  /**
   * @param window The Stage object that will be displayed
   */
  public void start(Stage window)
  {
    window.setTitle("ColourIT Project Manager");

    adapter = new ProjectFileAdapter("projects.bin");
    employeeAdapter = new EmployeeFileAdapter("employees.bin");
    listener = new MyActionListener();
    tabListener = new MyTabListener();
    projectListener = new MyProjectListListener();
    reqListener = new MyReqListListener();
    taskListener = new MyTaskListListener();

    tabPane = new TabPane();
    tabPane.getSelectionModel().selectedItemProperty().addListener(tabListener);

    // Projects Tab
    projectCreateButton = new Button("Create");
    projectCreateButton.setOnAction(listener);
    projectEditButton = new Button("Edit");
    projectEditButton.setOnAction(listener);
    projectRemoveButton = new Button("Remove");
    projectRemoveButton.setOnAction(listener);

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
        .addListener(projectListener);

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

    logo = new Image("file:img/logo.png");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);

    selectedProjectPane = new HBox(20);
    selectedProjectIdLabel = new Label("Selected Project:");
    selectedProjectIdOutput = new Label();
    selectedProjectPane.getChildren()
        .addAll(selectedProjectIdLabel, selectedProjectIdOutput);

    projectPane.getChildren().add(selectedProjectPane);
    projectPane.getChildren().add(projectTopPane);
    projectPane.getChildren().add(projectCreateButton);
    projectPane.getChildren().add(projectEditButton);
    projectPane.getChildren().add(projectRemoveButton);

    projectPane.getChildren().add(imagePane);
    projectTab = new Tab("Projects");
    projectTab.setContent(projectPane);

    // Requirements Tab
    reqCreateButton = new Button("Create");
    reqCreateButton.setOnAction(listener);
    reqEditButton = new Button("Edit");
    reqEditButton.setOnAction(listener);
    reqRemoveButton = new Button("Remove");
    reqRemoveButton.setOnAction(listener);

    reqPane = new VBox(20);
    reqPane.setPadding(new Insets(10));
    reqButtomPane = new HBox(20);
    reqTopPane = new HBox(20);

    allReqsTable = new TableView<Requirement>();
    reqDefaultSelectionModel = allReqsTable.getSelectionModel();
    allReqsTable.setPrefHeight(290);
    allReqsTable.getSelectionModel().selectedItemProperty()
        .addListener(reqListener);

    reqIdColumn = new TableColumn<Requirement, String>("Requirement ID");
    reqIdColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("id"));
    reqIdColumn.setPrefWidth(50);

    reqTypeColumn = new TableColumn<Requirement, String>("Type");
    reqTypeColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("type"));
    reqTypeColumn.setPrefWidth(100);


    reqPriorityColumn = new TableColumn<Requirement, String>("Priority");
    reqPriorityColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("priority"));
    reqPriorityColumn.setPrefWidth(100);
    reqPriorityColumn.setSortType(TableColumn.SortType.ASCENDING);

    reqStatusColumn = new TableColumn<Requirement, String>("Status");
    reqStatusColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("Status"));
    reqStatusColumn.setPrefWidth(100);

    reqDescriptionColumn = new TableColumn<Requirement, String>("Description");
    reqDescriptionColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("Description"));
    reqDescriptionColumn.setPrefWidth(350);

    reqDeadlineColumn = new TableColumn<Requirement, String>("Deadline");
    reqDeadlineColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("Deadline"));
    reqDeadlineColumn.setPrefWidth(100);

    reqTimeEstimateColumn = new TableColumn<Requirement, String>(
        "Time Estimate");
    reqTimeEstimateColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("TimeEstimate"));
    reqTimeEstimateColumn.setPrefWidth(100);

    reqTotalHoursColumn = new TableColumn<Requirement, String>("Total Hours");
    reqTotalHoursColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("TotalHours"));
    reqTotalHoursColumn.setPrefWidth(100);

    reqTeamMemberColumn = new TableColumn<Requirement, String>("Team Member");
    reqTeamMemberColumn.setCellValueFactory(
        new PropertyValueFactory<Requirement, String>("TeamMember"));
    reqTeamMemberColumn.setPrefWidth(100);


    allReqsTable.getColumns().add(reqIdColumn);
    allReqsTable.getColumns().add(reqTypeColumn);
    allReqsTable.getColumns().add(reqPriorityColumn);
    allReqsTable.getColumns().add(reqStatusColumn);
    allReqsTable.getColumns().add(reqDescriptionColumn);
    allReqsTable.getColumns().add(reqDeadlineColumn);
    allReqsTable.getColumns().add(reqTimeEstimateColumn);
    allReqsTable.getColumns().add(reqTotalHoursColumn);
    allReqsTable.getColumns().add(reqTeamMemberColumn);



    reqTablePane = new FlowPane();
    reqTablePane.setAlignment(Pos.BASELINE_RIGHT);
    reqTablePane.setPrefWidth(200);
    reqTablePane.getChildren().add(allReqsTable);

    reqIdLabel = new Label("Requirement ID:");
    reqStatusLabel = new Label("Status:");
    reqDescriptionLabel = new Label("Description:");
    reqDayLabel = new Label("Day:");
    reqMonthLabel = new Label("Month:");
    reqYearLabel = new Label("Year:");
    reqTimeEstimateLabel = new Label("Time Estimate:");
    reqTotalHoursLabel = new Label("Total Hours");
    reqTMLabel = new Label("Team Member:");
    reqPriorityLabel = new Label("Priority:");
    reqTypeLabel = new Label("Type:");

    reqIdField = new TextField();
    reqDescriptionField = new TextField();
    reqDayField = new TextField();
    reqMonthField = new TextField();
    reqYearField = new TextField();
    reqTimeEstimateField = new TextField();
    reqTotalHoursField = new TextField();

    reqTMBox = new ComboBox<Employee>();

    String[] reqStatus = {"Not Started", "Started", "Ended", "Approved",
        "Rejected"};
    reqStatusBox = new ComboBox<String>(
        FXCollections.observableArrayList(reqStatus));

    reqPriorityBox = new ComboBox<String>();
    String[] reqPriority = {"Critical", "High", "Low"};
    reqPriorityBox = new ComboBox<String>(FXCollections
        .observableArrayList(reqPriority));


    reqTypeBox = new ComboBox<>();
    String[] reqType = { "Functional", "Non Functional"};
    reqTypeBox = new ComboBox<String>(FXCollections
        .observableArrayList(reqType));



    reqInputPane = new GridPane();
    reqInputPane.setHgap(5);
    reqInputPane.setVgap(5);
    reqInputPane.addRow(0, reqIdLabel, reqIdField);
    reqInputPane.addRow(1, reqPriorityLabel,reqPriorityBox);
    reqInputPane.addRow(2, reqTypeLabel, reqTypeBox);
    reqInputPane.addRow(3, reqStatusLabel, reqStatusBox);
    reqInputPane.addRow(4, reqDescriptionLabel, reqDescriptionField);
    reqInputPane.addRow(5, reqDayLabel, reqDayField);
    reqInputPane.addRow(6, reqMonthLabel, reqMonthField);
    reqInputPane.addRow(7, reqYearLabel, reqYearField);
    reqInputPane.addRow(8, reqTimeEstimateLabel, reqTimeEstimateField);
    reqInputPane.addRow(9, reqTotalHoursLabel, reqTotalHoursField);
    reqInputPane.addRow(10, reqTMLabel, reqTMBox);

    reqTopPane.getChildren().add(reqInputPane);
    reqTopPane.getChildren().add(allReqsTable);

    selectedReqPane = new HBox(20);
    selectedReqProjectIdLabel = new Label("Selected Project:");
    selectedReqProjectIdOutput = new Label();
    selectedReqIdLabel = new Label("Selected Requirement:");
    selectedReqIdOutput = new Label();
    selectedReqPane.getChildren()
        .addAll(selectedReqProjectIdLabel, selectedReqProjectIdOutput,
            selectedReqIdLabel, selectedReqIdOutput);
    reqButtomPane.getChildren()
        .addAll(reqCreateButton, reqEditButton, reqRemoveButton);
    reqPane.getChildren().add(selectedReqPane);
    reqPane.getChildren().add(reqTopPane);
    reqPane.getChildren().add(reqButtomPane);

    reqTab = new Tab("Requirements");
    reqTab.setContent(reqPane);

    // Tasks Tab

    taskCreateButton = new Button("Create");
    taskCreateButton.setOnAction(listener);

    taskEditButton = new Button("Edit");
    taskEditButton.setOnAction(listener);

    taskRemoveButton = new Button("Remove");
    taskRemoveButton.setOnAction(listener);

    taskPane = new VBox(20);
    taskPane.setPadding(new Insets(10));

    taskTopPane = new HBox(20);

    allTasksTable = new TableView<Task>();
    taskDefaultSelectionModel = allTasksTable.getSelectionModel();
    allTasksTable.setPrefHeight(290);
    allTasksTable.getSelectionModel().selectedItemProperty()
        .addListener(taskListener);

    taskIdColumn = new TableColumn<Task, String>("Task ID");
    taskIdColumn
        .setCellValueFactory(new PropertyValueFactory<Task, String>("id"));
    taskIdColumn.setPrefWidth(50);

    taskStatusColumn = new TableColumn<Task, String>("Status");
    taskStatusColumn
        .setCellValueFactory(new PropertyValueFactory<Task, String>("Status"));
    taskStatusColumn.setPrefWidth(100);

    taskDescriptionColumn = new TableColumn<Task, String>("Description");
    taskDescriptionColumn.setCellValueFactory(
        new PropertyValueFactory<Task, String>("Description"));
    taskDescriptionColumn.setPrefWidth(350);

    taskDeadlineColumn = new TableColumn<Task, String>("Deadline");
    taskDeadlineColumn.setCellValueFactory(
        new PropertyValueFactory<Task, String>("Deadline"));
    taskDeadlineColumn.setPrefWidth(100);

    taskTimeEstimateColumn = new TableColumn<Task, String>("Time Estimate");
    taskTimeEstimateColumn.setCellValueFactory(
        new PropertyValueFactory<Task, String>("TimeEstimate"));
    taskTimeEstimateColumn.setPrefWidth(100);

    taskTotalHoursColumn = new TableColumn<Task, String>("Total Hours");
    taskTotalHoursColumn.setCellValueFactory(
        new PropertyValueFactory<Task, String>("TotalHours"));
    taskTotalHoursColumn.setPrefWidth(100);

    taskTeamMemberColumn = new TableColumn<Task, String>("Team Member");
    taskTeamMemberColumn.setCellValueFactory(
        new PropertyValueFactory<Task, String>("TeamMember"));
    taskTeamMemberColumn.setPrefWidth(100);

    allTasksTable.getColumns().add(taskIdColumn);
    allTasksTable.getColumns().add(taskStatusColumn);
    allTasksTable.getColumns().add(taskDescriptionColumn);
    allTasksTable.getColumns().add(taskDeadlineColumn);
    allTasksTable.getColumns().add(taskTimeEstimateColumn);
    allTasksTable.getColumns().add(taskTotalHoursColumn);
    allTasksTable.getColumns().add(taskTeamMemberColumn);

    taskTablePane = new FlowPane();
    taskTablePane.setAlignment(Pos.BASELINE_RIGHT);
    taskTablePane.setPrefWidth(200);
    taskTablePane.getChildren().add(allTasksTable);

    taskIdLabel = new Label("Task ID:");
    taskStatusLabel = new Label("Status:");
    taskDescriptionLabel = new Label("Description:");
    taskDayLabel = new Label("Day:");
    taskMonthLabel = new Label("Month:");
    taskYearLabel = new Label("Year:");
    taskTimeEstimateLabel = new Label("Time Estimate:");
    taskTotalHoursLabel = new Label("Total Hours:");
    taskTeamMemberLabel = new Label("Team Member:");

    taskIdField = new TextField();
    taskStatusField = new TextField();
    taskDescriptionField = new TextField();
    taskDayField = new TextField();
    taskMonthField = new TextField();
    taskYearField = new TextField();
    taskTimeEstimateField = new TextField();
    taskTotalHoursField = new TextField();

    taskTMBox = new ComboBox<Employee>();

    String[] taskStatus = {"Not Started", "Started", "Ended"};
    taskStatusBox = new ComboBox<String>(
        FXCollections.observableArrayList(taskStatus));

    taskInputPane = new GridPane();
    taskInputPane.setHgap(5);
    taskInputPane.setVgap(5);
    taskInputPane.addRow(0, taskIdLabel, taskIdField);
    taskInputPane.addRow(1, taskStatusLabel, taskStatusBox);
    taskInputPane.addRow(2, taskDescriptionLabel, taskDescriptionField);
    taskInputPane.addRow(3, taskDayLabel, taskDayField);
    taskInputPane.addRow(4, taskMonthLabel, taskMonthField);
    taskInputPane.addRow(5, taskYearLabel, taskYearField);
    taskInputPane.addRow(6, taskTimeEstimateLabel, taskTimeEstimateField);
    taskInputPane.addRow(7, taskTotalHoursLabel, taskTotalHoursField);
    taskInputPane.addRow(8, taskTeamMemberLabel, taskTMBox);

    taskTopPane.getChildren().add(taskInputPane);
    taskTopPane.getChildren().add(allTasksTable);

    selectedTaskPane = new HBox(20);
    selectedTaskProjectIdLabel = new Label("Selected Project:");
    selectedTaskProjectIdOutput = new Label();
    selectedTaskReqIdLabel = new Label("Selected Requirement:");
    selectedTaskReqIdOutput = new Label();
    selectedTaskIdLabel = new Label("Selected Task:");
    selectedTaskIdOutput = new Label();
    selectedTaskPane.getChildren()
        .addAll(selectedTaskProjectIdLabel, selectedTaskProjectIdOutput,
            selectedTaskReqIdLabel, selectedTaskReqIdOutput,
            selectedTaskIdLabel, selectedTaskIdOutput);

    taskPane.getChildren().add(selectedTaskPane);
    taskPane.getChildren().add(taskTopPane);
    taskPane.getChildren().add(taskCreateButton);
    taskPane.getChildren().add(taskEditButton);
    taskPane.getChildren().add(taskRemoveButton);

    taskTab = new Tab("Task");
    taskTab.setContent(taskPane);

    // Employees

    employeeCreateButton = new Button("Create");
    employeeCreateButton.setOnAction(listener);

    employeeEditButton = new Button("Edit:");
    employeeEditButton.setOnAction(listener);

    employeeRemoveButton = new Button("Remove:");
    employeeRemoveButton.setOnAction(listener);

    employeePane = new VBox(20);
    employeePane.setPadding(new Insets(10));

    employeeTopPane = new HBox(20);

    allEmployeeTable = new TableView<Employee>();
    employeeDefaultSelectionModel = allEmployeeTable.getSelectionModel();
    allEmployeeTable.setPrefHeight(290);

    firstNameColumn = new TableColumn<Employee, String>("First name");
    firstNameColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("firstName"));
    firstNameColumn.setPrefWidth(165);

    lastNameColumn = new TableColumn<Employee, String>("Last name");
    lastNameColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("lastName"));
    lastNameColumn.setPrefWidth(165);

    roleColumn = new TableColumn<Employee, String>("Role");
    roleColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("role"));
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

    // comboBox for roles

    String[] roleStatus = {"Project Owner", "Project Creator", "Scrum Master",
        "Team Member"};
    rolesStatusBox = new ComboBox<String>(
        FXCollections.observableArrayList(roleStatus));

    employeeInputPane = new GridPane();
    employeeInputPane.setHgap(5);
    employeeInputPane.setVgap(5);
    employeeInputPane.addRow(0, firstNameLabel, firstNameField);
    employeeInputPane.addRow(1, lastNameLabel, lastNameField);
    employeeInputPane.addRow(2, roleLabel, rolesStatusBox);

    employeeTopPane.getChildren().add(employeeInputPane);
    employeeTopPane.getChildren().add(allEmployeeTable);

    employeePane.getChildren().add(employeeTopPane);
    employeePane.getChildren().add(employeeCreateButton);
    employeePane.getChildren().add(employeeEditButton);
    employeePane.getChildren().add(employeeRemoveButton);

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

    if (allProjectsTable.getSelectionModel().getSelectedItem() != null)
    {
      String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
          .getId();

      RequirementList requirements = adapter.getAllRequirements(projectId);
      for (int i = 0; i < requirements.size(); i++)
      {
        allReqsTable.getItems().add(requirements.getRequirement(i));
      }
    }
    else
    {
      if (currentIndex == -1 && allReqsTable.getItems().size() > 0)
      {
        allReqsTable.getSelectionModel().select(0);
      }
      else
      {
        allReqsTable.getSelectionModel().select(currentIndex);
      }
    }

  }

  public void updateTaskTable()
  {
    int currentIndex = allTasksTable.getSelectionModel().getSelectedIndex();

    allTasksTable.getItems().clear();

    if (allProjectsTable.getSelectionModel().getSelectedItem() != null
        && !(selectedTaskReqIdOutput.getText().equals("")))
    {
      String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
          .getId();
      String reqId = selectedTaskReqIdOutput.getText();

      TaskList tasks = adapter.getAllTasks(projectId, reqId);
      if (tasks != null)
      {
        for (int i = 0; i < tasks.size(); i++)
        {
          allTasksTable.getItems().add(tasks.getTask(i));
        }
      }
    }
    else
    {
      if (currentIndex == -1 && allTasksTable.getItems().size() > 0)
      {
        allTasksTable.getSelectionModel().select(0);
      }
      else
      {
        allTasksTable.getSelectionModel().select(currentIndex);
      }
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

  public void updateSelectedReq()
  {
    if (allProjectsTable.getSelectionModel().getSelectedItem() != null)
    {
      String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
          .getId();
      selectedReqProjectIdOutput.setText(projectId);

      if (allReqsTable.getSelectionModel().getSelectedItem() != null)
      {
        String reqId = allReqsTable.getSelectionModel().getSelectedItem()
            .getId();
        selectedReqIdOutput.setText(reqId);
      }
    }
  }

  public void updateSelectedTask()
  {
    if (allProjectsTable.getSelectionModel().getSelectedItem() != null)
    {
      String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
          .getId();
      selectedTaskProjectIdOutput.setText(projectId);

      if (allReqsTable.getSelectionModel().getSelectedItem() != null)
      {
        String reqId = allReqsTable.getSelectionModel().getSelectedItem()
            .getId();
        selectedTaskReqIdOutput.setText(reqId);

        if (allTasksTable.getSelectionModel().getSelectedItem() != null)
        {
          String taskId = allTasksTable.getSelectionModel().getSelectedItem()
              .getId();
          selectedTaskIdOutput.setText(taskId);
        }
      }

    }
  }

  public void updateTaskTMBox()
  {
    int currentIndex = taskTMBox.getSelectionModel().getSelectedIndex();

    taskTMBox.getItems().clear();

    EmployeeList employees = employeeAdapter.getAllEmployees();
    for (int i = 0; i < employees.size(); i++)
    {
      taskTMBox.getItems().add(employees.getEmployee(i));
    }

    if (currentIndex == -1 && taskTMBox.getItems().size() > 0)
    {
      taskTMBox.getSelectionModel().select(0);
    }
    else
    {
      taskTMBox.getSelectionModel().select(currentIndex);
    }
  }

  public void updateReqTMBox()
  {
    int currentIndex = reqTMBox.getSelectionModel().getSelectedIndex();

    reqTMBox.getItems().clear();

    EmployeeList employees = employeeAdapter.getAllEmployees();
    for (int i = 0; i < employees.size(); i++)
    {
      reqTMBox.getItems().add(employees.getEmployee(i));
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
      else if (e.getSource() == projectEditButton)
      {
        int currentIndex = allProjectsTable.getSelectionModel()
            .getSelectedIndex();

        String id = projectIdField.getText();
        String title = projectTitleField.getText();
        String description = projectDescriptionField.getText();

        ProjectList projects = adapter.getAllProjects();

        if (id.equals(""))
        {
          id = projects.getProject(currentIndex).getId();
        }
        if (description.equals(""))
        {
          description = projects.getProject(currentIndex).getDescription();
        }
        if (title.equals(""))
        {
          title = projects.getProject(currentIndex).getTitle();
        }

        Project project = new Project(id, title, description);
        RequirementList requirements = projects.getProject(currentIndex)
            .getRequirements();
        project.setRequirements(requirements);

        projects.removeProjectByIndex(currentIndex);
        projects.addProject(currentIndex, project);
        adapter.saveProjects(projects);
        updateProjectsTable();
        projectIdField.setText("");
        projectTitleField.setText("");
        projectDescriptionField.setText("");
      }
      else if (e.getSource() == projectRemoveButton)
      {
        int currentIndex = allProjectsTable.getSelectionModel()
            .getSelectedIndex();

        ProjectList projects = adapter.getAllProjects();

        projects.removeProjectByIndex(currentIndex);

        adapter.saveProjects(projects);
        updateProjectsTable();
      }
      else if (e.getSource() == reqCreateButton)
      {
        String id = reqIdField.getText();
        String status = reqStatusBox.getValue();
        String description = reqDescriptionField.getText();
        String priority = reqPriorityBox.getValue();
        String type = reqTypeBox.getValue();
        int day;
        int month;
        int year;
        double timeEstimate;
        double totalHours;
        Employee teamMember = reqTMBox.getValue();

        //time estimate

        if (reqTimeEstimateField.getText().equals(""))
        {
          timeEstimate = 0;
        }
        else
        {
          timeEstimate = Double.parseDouble(reqTimeEstimateField.getText());
        }

        //totalHours
        if (reqTotalHoursField.getText().equals(""))
        {
          totalHours = 0;
        }
        else
        {
          totalHours = Double.parseDouble(reqTotalHoursField.getText());
        }
        //date
        if (reqDayField.getText().equals(""))
        {
          day = 0;
        }
        else
        {
          day = Integer.parseInt(reqDayField.getText());

        }
        if (reqMonthField.getText().equals(""))
        {
          month = 0;
        }
        else
        {
          month = Integer.parseInt(reqMonthField.getText());

        }
        if (reqYearField.getText().equals(""))
        {
          year = 0;
        }
        else
        {
          year = Integer.parseInt(reqYearField.getText());

        }
        if(reqStatusBox.getSelectionModel().getSelectedIndex() == -1)
        {
          status = "Not Specified";
        }

        if(reqPriorityBox.getSelectionModel().getSelectedIndex() == -1)
        {
          priority = "Not Specified";
        }
        if(reqTypeBox.getSelectionModel().getSelectedIndex() == -1)
        {
          type = "Not Specified";
        }

        if(reqTMBox.getSelectionModel().getSelectedIndex() == -1)
        {
          teamMember = new Employee("None","","");
        }

        Date deadline = new Date(day, month, year);

        if (description.equals(""))
        {
          description = "none";
        }

        Requirement requirement = new Requirement(id, type, description,
            priority, status, totalHours, timeEstimate, deadline, teamMember);
        String projectId = allProjectsTable.getSelectionModel().getSelectedItem().getId();
        adapter.addRequirement(projectId, requirement);
        updateReqTable();
        reqIdField.setText("");
        reqDescriptionField.setText("");
        reqDayField.setText("");
        reqMonthField.setText("");
        reqYearField.setText("");
        reqTMBox.setValue(null);
        reqStatusBox.setValue(null);
        reqPriorityBox.setValue(null);
        reqTypeBox.setValue(null);
      }

      else if (e.getSource() == taskCreateButton)
      {
        boolean wrongEstimates = false;
        if (!selectedTaskProjectIdOutput.getText().equals("")
            && !selectedTaskReqIdOutput.getText().equals(""))
        {

          String projectId = selectedTaskProjectIdOutput.getText();
          String reqId = selectedTaskReqIdOutput.getText();

          RequirementList reqs = adapter.getAllRequirements(projectId);

          double timeEstimate;
          double currentEstimate = 0;
          if (taskTimeEstimateField.getText().equals(""))
          {
            timeEstimate = currentEstimate;
          }
          else
          {
            timeEstimate = Double.parseDouble(taskTimeEstimateField.getText());

            if (reqs.getRequirementById(reqId)
                .tooManyHours(currentEstimate, timeEstimate)
                && timeEstimate > currentEstimate)
            {
              timeEstimate = currentEstimate;
              Alert alert = new Alert(AlertType.ERROR,
                  "The total amount of estimate hours for the tasks are greater than the "
                      + "total estimate hours for the requirement.",
                  ButtonType.CLOSE);
              alert.setTitle("Error");
              alert.setHeaderText(null);

              alert.showAndWait();
              wrongEstimates = true;
            }
          }

          if (!wrongEstimates)
          {
            String id = taskIdField.getText();
            String status = taskStatusBox.getValue();
            String description = taskDescriptionField.getText();
            int day;
            if (!taskDayField.getText().equals(""))
            {
              day = Integer.parseInt(taskDayField.getText());
            }
            else
            {
              day = 0;
            }
            int month;
            if (!taskMonthField.getText().equals(""))
            {
              month = Integer.parseInt(taskMonthField.getText());
            }
            else
            {
              month = 0;
            }
            int year;
            if (!taskYearField.getText().equals(""))
            {
              year = Integer.parseInt(taskYearField.getText());
            }
            else
            {
              year = 0;
            }
            double totalHours;

            if (taskTotalHoursField.getText().equals(""))
            {
              totalHours = 0;

            }
            else
            {
              totalHours = Double.parseDouble(taskTotalHoursField.getText());
            }
            Employee teamMember = taskTMBox.getValue();

            if (description.equals(""))
            {
              description = "?";
            }

            Date date = new Date(day, month, year);
            Task task = new Task(id, status, description, timeEstimate,
                totalHours, date, teamMember);

            adapter.addTask(projectId, reqId, task);
            updateTaskTable();
            updateReqTable();
            taskIdField.setText("");
            taskStatusField.setText("");
            taskDescriptionField.setText("");
          }
        }
      }

      else if (e.getSource() == taskEditButton)
      {
        boolean wrongEstimates = false;
        int currentIndex;
        if (allTasksTable.getSelectionModel().getSelectedIndex() != -1)
        {
          currentIndex = allTasksTable.getSelectionModel().getSelectedIndex();

          if (!selectedTaskProjectIdOutput.getText().equals("")
              && !selectedTaskReqIdOutput.getText().equals(""))
          {
            String projectId = selectedTaskProjectIdOutput.getText();
            String reqId = selectedTaskReqIdOutput.getText();

            TaskList tasks = adapter.getAllTasks(projectId, reqId);
            RequirementList reqs = adapter.getAllRequirements(projectId);

            double timeEstimate;
            double currentEstimate = tasks.getTask(currentIndex)
                .getTimeEstimate();
            if (taskTimeEstimateField.getText().equals(""))
            {
              timeEstimate = currentEstimate;
            }
            else
            {
              timeEstimate = Double
                  .parseDouble(taskTimeEstimateField.getText());

              if (reqs.getRequirementById(reqId)
                  .tooManyHours(currentEstimate, timeEstimate)
                  && timeEstimate > currentEstimate)
              {
                timeEstimate = currentEstimate;
                Alert alert = new Alert(AlertType.ERROR,
                    "The total amount of estimate hours for the tasks are greater than the "
                        + "total estimate hours for the requirement.",
                    ButtonType.CLOSE);
                alert.setTitle("Error");
                alert.setHeaderText(null);

                alert.showAndWait();
                wrongEstimates = true;
              }
            }
            if (!wrongEstimates)
            {
              String id = taskIdField.getText();
              String status = taskStatusBox.getValue();
              String description = taskDescriptionField.getText();
              int day;
              if (!taskDayField.getText().equals(""))
              {
                day = Integer.parseInt(taskDayField.getText());
              }
              else
              {
                day = tasks.getTask(currentIndex).getDeadline().getDay();
                ;
              }
              int month;
              if (!taskMonthField.getText().equals(""))
              {
                month = Integer.parseInt(taskMonthField.getText());
              }
              else
              {
                month = tasks.getTask(currentIndex).getDeadline().getMonth();
                ;
              }
              int year;
              if (!taskYearField.getText().equals(""))
              {
                year = Integer.parseInt(taskYearField.getText());
              }
              else
              {
                year = tasks.getTask(currentIndex).getDeadline().getYear();
                ;
              }

              double totalHours;

              if (taskTotalHoursField.getText().equals(""))
              {
                totalHours = tasks.getTask(currentIndex).getTotalHours();

              }
              else
              {
                totalHours = Double.parseDouble(taskTotalHoursField.getText());
              }

              Employee teamMember = taskTMBox.getValue();

              if (id.equals(""))
              {
                id = tasks.getTask(currentIndex).getId();
              }
              if (description.equals(""))
              {
                description = tasks.getTask(currentIndex).getDescription();
              }

              Date date = new Date(day, month, year);
              Task task = new Task(id, status, description, timeEstimate,
                  totalHours, date, teamMember);

              tasks.removeByIndex(currentIndex);
              tasks.addByIndex(currentIndex, task);

              adapter.addTasks(projectId, reqId, tasks);
              updateReqTable();
              updateTaskTable();
              taskIdField.setText("");
              taskDescriptionField.setText("");
              taskDayField.setText("");
              taskMonthField.setText("");
              taskYearField.setText("");
              taskTimeEstimateField.setText("");
              taskTotalHoursField.setText("");
            }
          }
        }
      }

      else if (e.getSource() == taskRemoveButton)
      {
        int currentIndex;
        if (allTasksTable.getSelectionModel().getSelectedIndex() != -1)
        {
          currentIndex = allTasksTable.getSelectionModel().getSelectedIndex();

          if (!selectedTaskProjectIdOutput.getText().equals("")
              && !selectedTaskReqIdOutput.getText().equals(""))
          {
            String projectId = selectedTaskProjectIdOutput.getText();
            String reqId = selectedTaskReqIdOutput.getText();

            TaskList tasks = adapter.getAllTasks(projectId, reqId);

            tasks.removeByIndex(currentIndex);

            adapter.addTasks(projectId, reqId, tasks);
            updateTaskTable();
          }
        }
      }

      else if (e.getSource() == employeeCreateButton)
      {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String role = rolesStatusBox.getValue();

        if (firstName.equals(""))
        {
          firstName = "?";
        }
        if (lastName.equals(""))
        {
          lastName = "?";
        }
        if (role == null)
        {
          role = "?";
        }

        Employee employee = new Employee(firstName, lastName, role);

        employeeAdapter.addEmployee(employee);
        updateEmployeeTable();
        firstNameField.setText("");
        lastNameField.setText("");
        rolesStatusBox.setValue(null);
      }

      else if (e.getSource() == employeeEditButton)
      {
        int currentIndex = allEmployeeTable.getSelectionModel()
            .getSelectedIndex();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String role = rolesStatusBox.getValue();
        EmployeeList employeeList = employeeAdapter.getAllEmployees();

        if (role == null)
        {
          role = employeeList.getEmployee(currentIndex).getRole();

        }
        if (firstName.equals(""))
        {
          firstName = employeeList.getEmployee(currentIndex).getFirstName();
        }
        if (lastName.equals(""))
        {
          lastName = employeeList.getEmployee(currentIndex).getLastName();
        }

        Employee employee = new Employee(firstName, lastName, role);
        employeeList.remove(employeeList.getEmployee(currentIndex));
        employeeList.addByIndex(currentIndex, employee);

        employeeAdapter.saveEmployee(employeeList);
        updateEmployeeTable();
        firstNameField.setText("");
        lastNameField.setText("");
      }

      else if (e.getSource() == reqEditButton)
      {
        int currentIndex = allReqsTable.getSelectionModel().getSelectedIndex();

        String id = reqIdField.getText();
        String status = reqStatusBox.getValue();
        String description = reqDescriptionField.getText();
        String priority = reqPriorityBox.getValue();
        String type = reqTypeBox.getValue();
        String projectId = allProjectsTable.getSelectionModel().getSelectedItem()
            .getId();
        RequirementList reqList = adapter.getAllRequirements(projectId);
        int day;
        int month;
        int year;
        double timeEstimate;
        double totalHours ;
        Employee teamMember;

        if (id.equals(""))
        {
          id = reqList.getRequirement(currentIndex).getId();

        }

        if (description.equals(""))
        {
          description = reqList.getRequirement(currentIndex).getDescription();
        }

        if (reqDayField.getText().equals(""))
        {
          day = reqList.getRequirement(currentIndex).getDeadline().getDay();
        }
        else
        {
          day = Integer.parseInt(reqDayField.getText());

        }
        if (reqMonthField.getText().equals(""))
        {
          month = reqList.getRequirement(currentIndex).getDeadline().getMonth();
        }
        else
        {
          month = Integer.parseInt(reqMonthField.getText());

        }
        if (reqYearField.getText().equals(""))
        {
          year = reqList.getRequirement(currentIndex).getDeadline().getYear();
        }
        else
        {
          year = Integer.parseInt(reqYearField.getText());

        }
        if (reqTimeEstimateField.getText().equals(""))
        {
          timeEstimate = reqList.getRequirement(currentIndex).getTimeEstimate();
        }
        else
        {
          timeEstimate = Double.parseDouble(reqTimeEstimateField.getText());

        }
        if (reqTotalHoursField.getText().equals(""))
        {
          totalHours = reqList.getRequirement(currentIndex).getTotalHours();
        }
        else
        {
          totalHours = Double.parseDouble(reqTotalHoursField.getText());
        }
        if(reqStatusBox.getSelectionModel().getSelectedIndex() == -1)
        {
          status = reqList.getRequirement(currentIndex).getStatus();
        }

        if(reqPriorityBox.getSelectionModel().getSelectedIndex() == -1)
        {
          priority = reqList.getRequirement(currentIndex).getPriority();
        }
        if(reqTypeBox.getSelectionModel().getSelectedIndex() == -1)
        {
          type = reqList.getRequirement(currentIndex).getType();
        }


        if(reqTMBox.getSelectionModel().getSelectedIndex() == -1)
        {
          teamMember = reqList.getRequirement(currentIndex).getTeamMember();
        }
        else{
          teamMember = reqTMBox.getValue();
        }

        Date deadline = new Date(day, month, year);

        Requirement requirement = new Requirement(id, type, description, priority, status,
            totalHours, timeEstimate, deadline, teamMember);

        reqList.removeRequirement(reqList.getRequirement(currentIndex));

        requirement.setTasks(tasks);

        reqList.add(currentIndex, requirement);
        adapter.addRequirements(projectId, reqList);
        updateReqTable();

        reqIdField.setText("");
        reqDescriptionField.setText("");
        reqDayField.setText("");
        reqMonthField.setText("");
        reqYearField.setText("");
        reqTimeEstimateField.setText("");
        reqTotalHoursField.setText("");
        reqStatusBox.setValue(null);
        reqTMBox.setValue(null);
        reqPriorityBox.setValue(null);
        reqTypeBox.setValue(null);

      }
      else if (e.getSource() == reqRemoveButton)
      {
        String projectId = allProjectsTable.getSelectionModel()
            .getSelectedItem().getId();

        int currentIndex = allReqsTable.getSelectionModel().getSelectedIndex();

        ProjectList projects = adapter.getAllProjects();

        RequirementList reqList = adapter.getAllRequirements(projectId);

        reqList.removeReqByIndex(currentIndex);

        adapter.addRequirements(projectId, reqList);
        updateReqTable();
      }
      else if (e.getSource() == employeeRemoveButton)
      {
        int currentIndex = allEmployeeTable.getSelectionModel()
            .getSelectedIndex();
        EmployeeList employeeList = employeeAdapter.getAllEmployees();

        employeeList.removeByIndex(currentIndex);

        employeeAdapter.saveEmployee(employeeList);
        updateEmployeeTable();
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
        updateReqTable();
        updateSelectedReq();
        updateReqTMBox();
      }
      else if (newTab == taskTab)
      {
        updateSelectedTask();
        updateTaskTable();
        updateTaskTMBox();
      }
      else if (newTab == employeeTab)
      {
        updateEmployeeTable();
      }

    }
  }

  private class MyProjectListListener implements ChangeListener<Project>
  {
    public void changed(ObservableValue<? extends Project> project,
        Project oldProject, Project newProject)
    {
      Project temp = allProjectsTable.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        updateSelectedProject();

        projectIdField.setText(temp.getId());
        projectTitleField.setText(temp.getTitle());
        projectDescriptionField.setPromptText(temp.getDescription());

      }
    }
  }

  private class MyReqListListener implements ChangeListener<Requirement>
  {
    public void changed(ObservableValue<? extends Requirement> requirement,
        Requirement oldRequirement, Requirement newRequirement)
    {
      Requirement temp = allReqsTable.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        updateSelectedReq();
        reqIdField.setText(temp.getId());
        reqDescriptionField.setText(temp.getDescription());
      }
    }
  }

  private class MyTaskListListener implements ChangeListener<Task>
  {
    public void changed(ObservableValue<? extends Task> task, Task oldTask,
        Task newTask)
    {
      Task temp = allTasksTable.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        updateSelectedTask();
        taskIdField.setText(temp.getId());
        taskStatusField.setText(temp.getStatus());
        taskDescriptionField.setPromptText(temp.getDescription());
      }
    }

  }

}

