public class LoadData
{
  public static void main(String[] args)
  {
    // This class is only used to load data into the file. If you run this in your
    // system, remember to change the file path in the file variable.

    String file = "C:\\Users\\lfpon\\IdeaProjects\\SEP1.2\\projects.bin";
    ProjectFileAdapter pfa = new ProjectFileAdapter(
        file);

    ProjectList list = new ProjectList();
    list.addProject(new Project("123", "blablabla", "blablabla"));
    list.addProject(new Project("124", "blablabla", "blablabla"));
    list.addProject(new Project("143", "blablabla", "blablabla"));

    Requirement requirement = new Requirement("1", "Not Started", "dnklwdnmwqld");
    Requirement requirement1 = new Requirement();
    Requirement requirement2 = new Requirement();
    Requirement requirement3 = new Requirement();
    Requirement requirement4 = new Requirement();

    RequirementList requirements = new RequirementList();
    requirements.addRequirement(requirement);
    requirements.addRequirement(requirement1);
    requirements.addRequirement(requirement2);
    requirements.addRequirement(requirement3);
    requirements.addRequirement(requirement4);

    list.getProject(1).setRequirements(requirements);

    pfa.saveProjects(list);

    System.out.println("All Projects:");
    System.out.println(
        "------------------------------------------------------------");
    System.out.println(list);
  }
}