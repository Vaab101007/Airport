/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airport.views;

import airport.controllers.FlightController;
import airport.controllers.LocationController;
import airport.controllers.PassengerController;
import airport.controllers.PlaneController;
import airport.controllers.tables.FlightTableController;
import airport.controllers.tables.LocationTableController;
import airport.controllers.tables.PassengerTableController;
import airport.controllers.tables.PlaneTableController;
import airport.controllers.utils.PassengerParser;
import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Location;
import airport.models.Plane;
import airport.models.Flight;
import airport.models.Passenger;
import airport.models.storage.LocationStorage;
import airport.models.storage.PlaneStorage;
import airport.utils.ComboDataFiller;
import airport.utils.JsonLoader;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edangulo
 */
public class AirportFrame extends javax.swing.JFrame {

    private PassengerController passengerController = new PassengerController();
    private FlightController flightController = new FlightController();
    private PlaneController planeController = new PlaneController();
    private LocationController locationController = new LocationController();
    private FlightTableController flightTablecontroller = new FlightTableController();

    /**
     * Creates new form AirportFrame
     */
    private int x, y;
    private ArrayList<Passenger> passengers;
    private ArrayList<Plane> planes;
    private ArrayList<Location> locations;
    private ArrayList<Flight> flights;
//    private FlightStorage flightSto;
//    private PlaneStorage planeSto;
//    private LocationStorage locationSto; 

    public AirportFrame() {
        initComponents();

//        this.flightSto = AirportStorage.getInstance().getFlightStorage();
//        this.planeSto = AirportStorage.getInstance().getPlaneStorage();
//        this.locationSto= AirportStorage.getInstance().getLocationStorage();
        this.passengers = new ArrayList<>();
        this.planes = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.flights = new ArrayList<>();

        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);

        this.generateMonths();
        this.generateDays();
        this.generateHours();
        this.generateMinutes();
        this.blockPanels();

        JsonLoader loader = new JsonLoader();
        loader.loadAllData();

        this.planes = (ArrayList<Plane>) PlaneStorage.getInstance().getAllPlanes();
        this.locations = LocationStorage.getInstance().getAllLocations();

        ComboDataFiller.LoadPassenger(userSelect);
        ComboDataFiller.LoadPlanes(Plane_RegFlight);
        ComboDataFiller.LoadLocations(DepartureLoc_RegFlight);
        ComboDataFiller.LoadLocations(ArrivalLoc_RegFlight);
        ComboDataFiller.LoadLocations(ScaleLoc_RegFlight);
        ComboDataFiller.loadFlights(txtFlights_addPassengerToFlight);
        ComboDataFiller.loadFlights(txtFlights_delayFlights);
        ScaleLoc_RegFlight.addItem("None");
    }

    private String leftPad(String value) {
        return value.length() == 1 ? "0" + value : value;
    }

    private void blockPanels() {
        //9, 11
        for (int i = 1; i < ShowPassengers.getTabCount(); i++) {
            if (i != 9 && i != 11) {
                ShowPassengers.setEnabledAt(i, false);
            }
        }
    }

    private void generateMonths() {
        for (int i = 1; i < 13; i++) {
            boxPassengerRegMonth.addItem("" + i);
            textMonthDepartureDate_RegFlight.addItem("" + i);
            MONTH5.addItem("" + i);
        }
    }

    private void generateDays() {
        for (int i = 1; i < 32; i++) {
            boxPassengerRegDay.addItem("" + i);
            textDayDepartureDate_RegFlight.addItem("" + i);
            DAY5.addItem("" + i);
        }
    }

    private void generateHours() {
        for (int i = 0; i < 24; i++) {
            textHourDepartureDate_RegFlight.addItem("" + i);
            txtHourDuration_RegFlight.addItem("" + i);
            txtHourScaleDuration_RegFlight.addItem("" + i);
            jComboBox6.addItem("" + i);
        }
    }

    private void generateMinutes() {
        for (int i = 0; i < 60; i++) {
            DAY2.addItem("" + i);
            txtMinsDuration_RegFlight.addItem("" + i);
            txtMinsScaleDuration_RegFlight.addItem("" + i);
            jComboBox8.addItem("" + i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new airport.views.PanelRound();
        panelRound2 = new airport.views.PanelRound();
        jButton13 = new javax.swing.JButton();
        ShowPassengers = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        user = new javax.swing.JRadioButton();
        administrator = new javax.swing.JRadioButton();
        userSelect = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPassengerRegPhoneCode = new javax.swing.JTextField();
        txtRegPassengerID = new javax.swing.JTextField();
        txtPassengerRegYear = new javax.swing.JTextField();
        txtPassengerRegCountry = new javax.swing.JTextField();
        txtPassengerRegPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPassengerRegLastName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        boxPassengerRegMonth = new javax.swing.JComboBox<>();
        txtPassengerRegFirstName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        boxPassengerRegDay = new javax.swing.JComboBox<>();
        RegisterPassangerButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtPIaneID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPlaneBrand = new javax.swing.JTextField();
        txtPlaneModel = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPlaneMaxCapacity = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPlaneAirline = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CreatePlaneButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtAirportID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtAirportName = new javax.swing.JTextField();
        txtAirportCity = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtAirportCountry = new javax.swing.JTextField();
        txtAirportLatitude = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtAirportLongitude = new javax.swing.JTextField();
        createLocationButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtUpdID = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtUpdFirstName = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtUpdLastName = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtUpdYear = new javax.swing.JTextField();
        MONTH5 = new javax.swing.JComboBox<>();
        DAY5 = new javax.swing.JComboBox<>();
        txtUpdPhone = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtUpdPhoneCode = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtUpdCountry = new javax.swing.JTextField();
        updatePassengerButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        UserID_AddToFlight = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtFlights_addPassengerToFlight = new javax.swing.JComboBox<>();
        addFlightsButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PassengerFlightTable = new javax.swing.JTable();
        UpdateUserFlights_button = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        passengersTable = new javax.swing.JTable();
        refreshPassengerTable = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        showAllFlightsTable = new javax.swing.JTable();
        refreshAllFlightsButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        refreshPlanesTable = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        planesTable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        locationsTable = new javax.swing.JTable();
        refreshLocationTable = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtFlights_delayFlights = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        DelayFligthButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtPassengerId = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Plane_RegFlight = new javax.swing.JComboBox<>();
        DepartureLoc_RegFlight = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        ArrivalLoc_RegFlight = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ScaleLoc_RegFlight = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        textYearDepartureDate_RegFlight = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        textMonthDepartureDate_RegFlight = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        textDayDepartureDate_RegFlight = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        textHourDepartureDate_RegFlight = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        DAY2 = new javax.swing.JComboBox<>();
        txtHourDuration_RegFlight = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        txtMinsDuration_RegFlight = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        txtHourScaleDuration_RegFlight = new javax.swing.JComboBox<>();
        txtMinsScaleDuration_RegFlight = new javax.swing.JComboBox<>();
        CreateFlightButton = new javax.swing.JButton();
        panelRound3 = new airport.views.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setRadius(40);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelRound2MouseDragged(evt);
            }
        });
        panelRound2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRound2MousePressed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButton13.setText("X");
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(1083, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(jButton13)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        ShowPassengers.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        user.setText("User");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        administrator.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        administrator.setText("Administrator");
        administrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administratorActionPerformed(evt);
            }
        });
        jPanel1.add(administrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 164, -1, -1));

        userSelect.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        userSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User" }));
        userSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSelectActionPerformed(evt);
            }
        });
        jPanel1.add(userSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 130, -1));

        ShowPassengers.addTab("Administration", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel1.setText("Country:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel2.setText("ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel3.setText("First Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel4.setText("Last Name:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel5.setText("Birthdate:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel6.setText("+");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 20, -1));

        txtPassengerRegPhoneCode.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(txtPassengerRegPhoneCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 50, -1));

        txtRegPassengerID.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(txtRegPassengerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, -1));

        txtPassengerRegYear.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(txtPassengerRegYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, -1));

        txtPassengerRegCountry.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(txtPassengerRegCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 130, -1));

        txtPassengerRegPhone.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(txtPassengerRegPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 130, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel7.setText("Phone:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel8.setText("-");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 30, -1));

        txtPassengerRegLastName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(txtPassengerRegLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 130, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel9.setText("-");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 30, -1));

        boxPassengerRegMonth.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        boxPassengerRegMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));
        jPanel2.add(boxPassengerRegMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        txtPassengerRegFirstName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(txtPassengerRegFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 130, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel10.setText("-");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 30, -1));

        boxPassengerRegDay.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        boxPassengerRegDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));
        boxPassengerRegDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPassengerRegDayActionPerformed(evt);
            }
        });
        jPanel2.add(boxPassengerRegDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        RegisterPassangerButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        RegisterPassangerButton.setText("Register");
        RegisterPassangerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterPassangerButtonActionPerformed(evt);
            }
        });
        jPanel2.add(RegisterPassangerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        ShowPassengers.addTab("Passenger registration", jPanel2);

        jPanel3.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel11.setText("ID:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(53, 96, 22, 25);

        txtPIaneID.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel3.add(txtPIaneID);
        txtPIaneID.setBounds(180, 93, 130, 31);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel12.setText("Brand:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(53, 157, 50, 25);

        txtPlaneBrand.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel3.add(txtPlaneBrand);
        txtPlaneBrand.setBounds(180, 154, 130, 31);

        txtPlaneModel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel3.add(txtPlaneModel);
        txtPlaneModel.setBounds(180, 213, 130, 31);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel13.setText("Model:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(53, 216, 55, 25);

        txtPlaneMaxCapacity.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel3.add(txtPlaneMaxCapacity);
        txtPlaneMaxCapacity.setBounds(180, 273, 130, 31);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel14.setText("Max Capacity:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(53, 276, 109, 25);

        txtPlaneAirline.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel3.add(txtPlaneAirline);
        txtPlaneAirline.setBounds(180, 333, 130, 31);

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel15.setText("Airline:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(53, 336, 70, 25);

        CreatePlaneButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        CreatePlaneButton.setText("Create");
        CreatePlaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePlaneButtonActionPerformed(evt);
            }
        });
        jPanel3.add(CreatePlaneButton);
        CreatePlaneButton.setBounds(490, 480, 120, 40);

        ShowPassengers.addTab("Airplane registration", jPanel3);

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel16.setText("Airport ID:");

        txtAirportID.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel17.setText("Airport name:");

        txtAirportName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtAirportCity.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel18.setText("Airport city:");

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel19.setText("Airport country:");

        txtAirportCountry.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtAirportLatitude.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel20.setText("Airport latitude:");

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel21.setText("Airport longitude:");

        txtAirportLongitude.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        createLocationButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        createLocationButton.setText("Create");
        createLocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLocationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAirportLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAirportID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAirportName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAirportCity, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAirportCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAirportLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(createLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(515, 515, 515))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel17)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel18)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel19)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel20))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtAirportID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtAirportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtAirportCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtAirportCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtAirportLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtAirportLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(createLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        ShowPassengers.addTab("Location registration", jPanel13);

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel36.setText("ID:");

        txtUpdID.setEditable(false);
        txtUpdID.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtUpdID.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel37.setText("First Name:");

        txtUpdFirstName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel38.setText("Last Name:");

        txtUpdLastName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel39.setText("Birthdate:");

        txtUpdYear.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        MONTH5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        MONTH5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        DAY5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        DAY5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        txtUpdPhone.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel40.setText("-");

        txtUpdPhoneCode.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel41.setText("+");

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel42.setText("Phone:");

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel43.setText("Country:");

        txtUpdCountry.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        updatePassengerButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        updatePassengerButton.setText("Update");
        updatePassengerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePassengerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(108, 108, 108)
                                .addComponent(txtUpdID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(41, 41, 41)
                                .addComponent(txtUpdFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(43, 43, 43)
                                .addComponent(txtUpdLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(55, 55, 55)
                                .addComponent(txtUpdYear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(MONTH5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(DAY5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtUpdPhoneCode, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtUpdPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(63, 63, 63)
                                .addComponent(txtUpdCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(updatePassengerButton)))
                .addContainerGap(586, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(txtUpdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(txtUpdFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(txtUpdLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(txtUpdYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MONTH5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DAY5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(txtUpdPhoneCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(txtUpdPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(txtUpdCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(updatePassengerButton)
                .addGap(113, 113, 113))
        );

        ShowPassengers.addTab("Update info", jPanel5);

        UserID_AddToFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        UserID_AddToFlight.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel44.setText("ID:");

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel45.setText("Flight:");

        txtFlights_addPassengerToFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtFlights_addPassengerToFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flight" }));

        addFlightsButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        addFlightsButton.setText("Add");
        addFlightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFlightsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(79, 79, 79)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFlights_addPassengerToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserID_AddToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(860, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addFlightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(509, 509, 509))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel44))
                    .addComponent(UserID_AddToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtFlights_addPassengerToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(addFlightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        ShowPassengers.addTab("Add to flight", jPanel6);

        PassengerFlightTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        PassengerFlightTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Departure Date", "Arrival Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(PassengerFlightTable);

        UpdateUserFlights_button.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        UpdateUserFlights_button.setText("Refresh");
        UpdateUserFlights_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateUserFlights_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdateUserFlights_button)
                .addGap(527, 527, 527))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(UpdateUserFlights_button)
                .addContainerGap())
        );

        ShowPassengers.addTab("Show my flights", jPanel7);

        passengersTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        passengersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Birthdate", "Age", "Phone", "Country", "Num Flight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(passengersTable);

        refreshPassengerTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        refreshPassengerTable.setText("Refresh");
        refreshPassengerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshPassengerTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(refreshPassengerTable))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addComponent(refreshPassengerTable)
                .addContainerGap())
        );

        ShowPassengers.addTab("Show all passengers", jPanel8);

        showAllFlightsTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        showAllFlightsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Departure Airport ID", "Arrival Airport ID", "Scale Airport ID", "Departure Date", "Arrival Date", "Plane ID", "Number Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(showAllFlightsTable);

        refreshAllFlightsButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        refreshAllFlightsButton.setText("Refresh");
        refreshAllFlightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAllFlightsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(refreshAllFlightsButton)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshAllFlightsButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ShowPassengers.addTab("Show all flights", jPanel9);

        refreshPlanesTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        refreshPlanesTable.setText("Refresh");
        refreshPlanesTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshPlanesTableActionPerformed(evt);
            }
        });

        planesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand", "Model", "Max Capacity", "Airline", "Number Flights"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(planesTable);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(refreshPlanesTable))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(refreshPlanesTable)
                .addGap(17, 17, 17))
        );

        ShowPassengers.addTab("Show all planes", jPanel10);

        locationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airport ID", "Airport Name", "City", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(locationsTable);

        refreshLocationTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        refreshLocationTable.setText("Refresh");
        refreshLocationTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshLocationTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(refreshLocationTable))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(303, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(refreshLocationTable)
                .addGap(17, 17, 17))
        );

        ShowPassengers.addTab("Show all locations", jPanel11);

        jComboBox6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel46.setText("Hours:");

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel47.setText("ID:");

        txtFlights_delayFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtFlights_delayFlights.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel48.setText("Minutes:");

        jComboBox8.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        DelayFligthButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        DelayFligthButton.setText("Delay");
        DelayFligthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelayFligthButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel46))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox6, 0, 136, Short.MAX_VALUE)
                            .addComponent(txtFlights_delayFlights, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(820, 820, 820))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DelayFligthButton)
                .addGap(531, 531, 531))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtFlights_delayFlights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(DelayFligthButton)
                .addGap(33, 33, 33))
        );

        ShowPassengers.addTab("Delay flight", jPanel12);

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel22.setText("ID:");

        txtPassengerId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel23.setText("Plane:");

        Plane_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        Plane_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plane" }));

        DepartureLoc_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        DepartureLoc_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));
        DepartureLoc_RegFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartureLoc_RegFlightActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel24.setText("Departure location:");

        ArrivalLoc_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        ArrivalLoc_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel25.setText("Arrival location:");

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel26.setText("Scale location:");

        ScaleLoc_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        ScaleLoc_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel27.setText("Duration:");

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel28.setText("Duration:");

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel29.setText("Departure date:");

        textYearDepartureDate_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel30.setText("-");

        textMonthDepartureDate_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        textMonthDepartureDate_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel31.setText("-");

        textDayDepartureDate_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        textDayDepartureDate_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel32.setText("-");

        textHourDepartureDate_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        textHourDepartureDate_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel33.setText("-");

        DAY2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        DAY2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        txtHourDuration_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtHourDuration_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel34.setText("-");

        txtMinsDuration_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtMinsDuration_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel35.setText("-");

        txtHourScaleDuration_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtHourScaleDuration_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        txtMinsScaleDuration_RegFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtMinsScaleDuration_RegFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        CreateFlightButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        CreateFlightButton.setText("Create");
        CreateFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateFlightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ScaleLoc_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ArrivalLoc_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(46, 46, 46)
                        .addComponent(DepartureLoc_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassengerId)
                            .addComponent(Plane_RegFlight, 0, 130, Short.MAX_VALUE))))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textYearDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(textMonthDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(textDayDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(textHourDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(DAY2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtHourDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txtMinsDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtHourScaleDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txtMinsScaleDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateFlightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(530, 530, 530))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addComponent(txtPassengerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(Plane_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textHourDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(DAY2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(DepartureLoc_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addComponent(textYearDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMonthDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(textDayDepartureDate_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(ArrivalLoc_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28))
                            .addComponent(txtHourDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(txtMinsDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHourScaleDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(txtMinsScaleDuration_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26)
                                .addComponent(ScaleLoc_RegFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(CreateFlightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        txtPassengerId.getAccessibleContext().setAccessibleName("");

        ShowPassengers.addTab("Flight registration", jPanel4);

        panelRound1.add(ShowPassengers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 1150, 620));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 660, 1150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void panelRound2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelRound2MousePressed

    private void panelRound2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_panelRound2MouseDragged

    private void administratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administratorActionPerformed
        if (user.isSelected()) {
            user.setSelected(false);
            userSelect.setSelectedIndex(0);

        }
        for (int i = 1; i < ShowPassengers.getTabCount(); i++) {
            ShowPassengers.setEnabledAt(i, true);
        }
        ShowPassengers.setEnabledAt(5, false);
        ShowPassengers.setEnabledAt(6, false);
    }//GEN-LAST:event_administratorActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        if (administrator.isSelected()) {
            administrator.setSelected(false);
        }
        for (int i = 1; i < ShowPassengers.getTabCount(); i++) {

            ShowPassengers.setEnabledAt(i, false);

        }
        ShowPassengers.setEnabledAt(9, true);
        ShowPassengers.setEnabledAt(5, true);
        ShowPassengers.setEnabledAt(6, true);
        ShowPassengers.setEnabledAt(7, true);
        ShowPassengers.setEnabledAt(11, true);
    }//GEN-LAST:event_userActionPerformed

    private void RegisterPassangerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String id = txtRegPassengerID.getText().trim(); //long
        String firstname = txtPassengerRegFirstName.getText().trim();
        String lastname = txtPassengerRegLastName.getText().trim();
        String year = txtPassengerRegYear.getText().trim(); ///int 
        String month = boxPassengerRegMonth.getSelectedItem().toString().trim(); //int 
        String day = boxPassengerRegDay.getSelectedItem().toString().trim();
        String phoneCode = txtPassengerRegPhoneCode.getText().trim(); //integer
        String phone = txtPassengerRegPhone.getText().trim(); //long
        String country = txtPassengerRegCountry.getText().trim();

        Response response = passengerController.createPassenger(id, firstname, lastname, year, month, day, phoneCode, phone, country);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success " + response.getStatus(), JOptionPane.INFORMATION_MESSAGE);

            // 4. Se actualiza y limpia los campos
            userSelect.addItem(id);
            txtRegPassengerID.setText("");
            txtPassengerRegFirstName.setText("");
            txtPassengerRegLastName.setText("");
            txtPassengerRegYear.setText("");
            txtPassengerRegPhoneCode.setText("");
            txtPassengerRegPhone.setText("");
            txtPassengerRegCountry.setText("");
            boxPassengerRegMonth.setSelectedIndex(0);
            boxPassengerRegDay.setSelectedIndex(0);
        }

    }

    private void CreatePlaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePlaneButtonActionPerformed

        String id = txtPIaneID.getText().trim();
        String brand = txtPlaneBrand.getText().trim();
        String model = txtPlaneModel.getText().trim();
        String maxCapacity = txtPlaneMaxCapacity.getText().trim();
        String airline = txtPlaneAirline.getText().trim();

        Response<Plane> response = PlaneController.createPlane(id, brand, model, airline, maxCapacity);

        if (response.getStatus() == Status.CREATED) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Avión Registrado", JOptionPane.INFORMATION_MESSAGE);

            Plane created = response.getData();
            this.planes.add(created);

            Plane_RegFlight.addItem(id);
            txtPIaneID.setText("");
            txtPlaneBrand.setText("");
            txtPlaneModel.setText("");
            txtPlaneMaxCapacity.setText("");
            txtPlaneAirline.setText("");
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_CreatePlaneButtonActionPerformed

    private void createLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLocationButtonActionPerformed
        // TODO add your handling code here:
        String id = txtAirportID.getText().trim();
        String name = txtAirportName.getText().trim();
        String city = txtAirportCity.getText().trim();
        String country = txtAirportCountry.getText().trim();
        String latitude = txtAirportLatitude.getText().trim(); //double
        String longitude = txtAirportLongitude.getText().trim(); // double

        Response<Location> response = locationController.createLocation(id, name, city, country, latitude, longitude);

        // 3. Mostrar resultado
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success " + response.getStatus(), JOptionPane.INFORMATION_MESSAGE);

            Location created = response.getData();
            this.locations.add(created);

            // 4. Si fue exitoso: actualizo combos y limpio campos
            String createdId = response.getData().getAirportId();
            DepartureLoc_RegFlight.addItem(createdId);
            ArrivalLoc_RegFlight.addItem(createdId);
            ScaleLoc_RegFlight.addItem(createdId);

            txtAirportID.setText("");
            txtAirportName.setText("");
            txtAirportCity.setText("");
            txtAirportCountry.setText("");
            txtAirportLatitude.setText("");
            txtAirportLongitude.setText("");
        }
    }//GEN-LAST:event_createLocationButtonActionPerformed

    private void CreateFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateFlightButtonActionPerformed
        String id = txtPassengerId.getText().trim();
        String planeId = Plane_RegFlight.getSelectedItem().toString().trim();
        String departureLocationId = DepartureLoc_RegFlight.getSelectedItem().toString().trim();
        String arrivalLocationId = ArrivalLoc_RegFlight.getSelectedItem().toString().trim();
        String scaleLocationId = ScaleLoc_RegFlight.getSelectedItem().toString().trim();

        // Fecha/hora sin parsear, solo formateada
        String year = textYearDepartureDate_RegFlight.getText().trim();
        String month = textMonthDepartureDate_RegFlight.getSelectedItem().toString().trim();
        String day = textDayDepartureDate_RegFlight.getSelectedItem().toString().trim();
        String hour = textHourDepartureDate_RegFlight.getSelectedItem().toString().trim();
        String minutes = DAY2.getSelectedItem().toString().trim();

        if (year.isEmpty() || month.isEmpty() || day.isEmpty() || hour.isEmpty() || minutes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos de fecha y hora.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formato ISO8601: yyyy-MM-ddTHH:mm
        String departureDateStr = year + "-" + leftPad(month) + "-" + leftPad(day) + "T" + leftPad(hour) + ":" + leftPad(minutes);

        String hoursArrStr = txtHourDuration_RegFlight.getSelectedItem().toString().trim();
        String minutesArrStr = txtMinsDuration_RegFlight.getSelectedItem().toString().trim();
        String hoursScaleStr = txtHourScaleDuration_RegFlight.getSelectedItem().toString().trim();
        String minutesScaleStr = txtMinsScaleDuration_RegFlight.getSelectedItem().toString().trim();

        Plane plane = null;
        for (Plane p : this.planes) {
            if (planeId.equals(p.getId())) {
                plane = p;
                break;
            }
        }

        Location departure = null, arrival = null, scale = null;

        for (Location loc : this.locations) {
            if (loc.getAirportId().equals(departureLocationId)) {
                departure = loc;
            }
            if (loc.getAirportId().equals(arrivalLocationId)) {
                arrival = loc;
            }
            if (loc.getAirportId().equals(scaleLocationId)) {
                scale = loc;
            }
        }

// 🔥 Validación para que "None" no se interprete como escala válida
// 🔥 Validación para que "None" no se interprete como escala válida
        if ("None".equals(scaleLocationId)) {
            scale = null;

            // Validar que la duración de escala sea 0 si no hay escala
            if (!hoursScaleStr.equals("0") || !minutesScaleStr.equals("0")) {
                JOptionPane.showMessageDialog(this,
                        "Si no hay escala seleccionada, la duración de la escala debe ser 0:00.",
                        "Error de validación",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        Response<Flight> response = flightController.createFlight(
                id, plane, departure, scale, arrival,
                departureDateStr,
                hoursArrStr, minutesArrStr,
                hoursScaleStr, minutesScaleStr
        );

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Advertencia " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            Flight newFlight = response.getData();
            plane.addFlight(newFlight);

            DefaultTableModel model = (DefaultTableModel) planesTable.getModel();
            PlaneTableController.updatePlaneTable(model);

            JOptionPane.showMessageDialog(this, response.getMessage(), "Éxito " + response.getStatus(), JOptionPane.INFORMATION_MESSAGE);
            txtFlights_addPassengerToFlight.addItem(id);
        }
    }//GEN-LAST:event_CreateFlightButtonActionPerformed

    private void updatePassengerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePassengerButtonActionPerformed
        // TODO add your handling code here: 
        String id = txtUpdID.getText().trim();
        String firstname = txtUpdFirstName.getText().trim();
        String lastname = txtUpdLastName.getText().trim();
        String year = txtUpdYear.getText().trim();
        String month = boxPassengerRegMonth.getSelectedItem().toString().trim();
        String day = boxPassengerRegDay.getSelectedItem().toString().trim();
        String phoneCode = txtUpdPhoneCode.getText();
        String phone = txtUpdPhone.getText();
        String country = txtUpdCountry.getText();

        String birthDate = year + month + day;
        // 2. Usar el parser para convertir los strings en un PassengerModel
        Response<Passenger> parsed = PassengerParser.parse(
                id, firstname, lastname, year, month, day,
                phoneCode, phone, country
        );

        if (parsed.getStatus() >= 500) {
            JOptionPane.showMessageDialog(this, parsed.getMessage(), "Error " + parsed.getStatus(), JOptionPane.ERROR_MESSAGE);
            return;
        } else if (parsed.getStatus() >= 400) {
            JOptionPane.showMessageDialog(this, parsed.getMessage(), "Error " + parsed.getStatus(), JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Si parseó bien, intentar actualizar
        Passenger passenger = parsed.getData();
        Response response = passengerController.updatePassenger(passenger);

        // 4. Mostrar mensaje de estado
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success " + response.getStatus(), JOptionPane.INFORMATION_MESSAGE);

            // 5. Si fue exitoso, limpiar campos
            txtUpdID.setText("");
            txtUpdFirstName.setText("");
            txtUpdLastName.setText("");
            txtUpdYear.setText("");
            txtUpdPhoneCode.setText("");
            txtUpdPhone.setText("");
            txtUpdCountry.setText("");
            boxPassengerRegMonth.setSelectedIndex(0);
            boxPassengerRegDay.setSelectedIndex(0);
        }


    }//GEN-LAST:event_updatePassengerButtonActionPerformed

    private void addFlightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFlightsButtonActionPerformed
        // TODO add your handling code here:

        // Obtener el texto del campo de ID del pasajero
        String idText = UserID_AddToFlight.getText().trim();

        // Validar si está vacío
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa el ID del pasajero.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        long passengerId;

        try {
            passengerId = Long.parseLong(idText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID del pasajero debe ser un número válido.", "Formato inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el ID del vuelo desde el combo
        String flightId = txtFlights_addPassengerToFlight.getItemAt(txtFlights_addPassengerToFlight.getSelectedIndex());

        // Intentar vincular
        boolean success = flightController.linkPassengerToFlight(flightId, passengerId);

        if (success) {
            JOptionPane.showMessageDialog(this, "Pasajero añadido al vuelo", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // refreshAllFlightsButtonActionPerformed(null); // ← Descomenta si querés refrescar la tabla
        } else {
            JOptionPane.showMessageDialog(this, "Error al añadir pasajero al vuelo. Verifica que el pasajero y vuelo existan.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addFlightsButtonActionPerformed


    private void DelayFligthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelayFligthButtonActionPerformed
        // 1. Obtener los datos desde los componentes de la vista
        String flightId = txtFlights_delayFlights.getItemAt(txtFlights_delayFlights.getSelectedIndex()).trim();
        String hoursStr = jComboBox6.getItemAt(jComboBox6.getSelectedIndex()).trim();
        String minutesStr = jComboBox8.getItemAt(jComboBox8.getSelectedIndex()).trim();

        // 2. Llamar al controlador
        Response<Flight> response = flightController.delayFlight(flightId, hoursStr, minutesStr);

        // 3. Mostrar mensajes según el resultado
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Advertencia " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Éxito " + response.getStatus(), JOptionPane.INFORMATION_MESSAGE);

            // 4. (Opcional) Actualizar la tabla de vuelos si la tienes
            // FlightTableController.updateFlightTable(myFlightTableModel);
        }
    }//GEN-LAST:event_DelayFligthButtonActionPerformed

    private void UpdateUserFlights_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateUserFlights_buttonActionPerformed
        PassengerTableController controller = new PassengerTableController();
        controller.viewUserFlight(PassengerFlightTable, userSelect);
    }//GEN-LAST:event_UpdateUserFlights_buttonActionPerformed

    private void refreshPassengerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshPassengerTableActionPerformed
        DefaultTableModel model = (DefaultTableModel) passengersTable.getModel();
        Response response = PassengerTableController.updatePassengerTable(model);
    }//GEN-LAST:event_refreshPassengerTableActionPerformed

    private void refreshAllFlightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAllFlightsButtonActionPerformed

        Response<List<String[]>> response = flightTablecontroller.refreshTableData();

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Advertencia " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            List<String[]> flightData = response.getData();
            DefaultTableModel model = (DefaultTableModel) showAllFlightsTable.getModel(); // <- cambia esto con el nombre real
            model.setRowCount(0); // limpia la tabla

            for (String[] row : flightData) {
                model.addRow(row);
            }

            JOptionPane.showMessageDialog(this, response.getMessage(), "Éxito " + response.getStatus(), JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_refreshAllFlightsButtonActionPerformed

    private void refreshPlanesTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshPlanesTableActionPerformed
        DefaultTableModel model = (DefaultTableModel) planesTable.getModel();
        Response response = PlaneTableController.updatePlaneTable(model);

    }//GEN-LAST:event_refreshPlanesTableActionPerformed

    private void refreshLocationTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshLocationTableActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) locationsTable.getModel();
        Response response = LocationTableController.updateLocationTable(model);
    }//GEN-LAST:event_refreshLocationTableActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void userSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSelectActionPerformed
        try {
            String id = userSelect.getSelectedItem().toString();
            if (!id.equals(userSelect.getItemAt(0))) {
                txtUpdID.setText(id);
                UserID_AddToFlight.setText(id);
            } else {
                txtUpdID.setText("");
                UserID_AddToFlight.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_userSelectActionPerformed

    private void boxPassengerRegDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPassengerRegDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxPassengerRegDayActionPerformed

    private void DepartureLoc_RegFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartureLoc_RegFlightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartureLoc_RegFlightActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AirportFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ArrivalLoc_RegFlight;
    private javax.swing.JButton CreateFlightButton;
    private javax.swing.JButton CreatePlaneButton;
    private javax.swing.JComboBox<String> DAY2;
    private javax.swing.JComboBox<String> DAY5;
    private javax.swing.JButton DelayFligthButton;
    private javax.swing.JComboBox<String> DepartureLoc_RegFlight;
    private javax.swing.JComboBox<String> MONTH5;
    private javax.swing.JTable PassengerFlightTable;
    private javax.swing.JComboBox<String> Plane_RegFlight;
    private javax.swing.JButton RegisterPassangerButton;
    private javax.swing.JComboBox<String> ScaleLoc_RegFlight;
    private javax.swing.JTabbedPane ShowPassengers;
    private javax.swing.JButton UpdateUserFlights_button;
    private javax.swing.JTextField UserID_AddToFlight;
    private javax.swing.JButton addFlightsButton;
    private javax.swing.JRadioButton administrator;
    private javax.swing.JComboBox<String> boxPassengerRegDay;
    private javax.swing.JComboBox<String> boxPassengerRegMonth;
    private javax.swing.JButton createLocationButton;
    private javax.swing.JButton jButton13;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable locationsTable;
    private airport.views.PanelRound panelRound1;
    private airport.views.PanelRound panelRound2;
    private airport.views.PanelRound panelRound3;
    private javax.swing.JTable passengersTable;
    private javax.swing.JTable planesTable;
    private javax.swing.JButton refreshAllFlightsButton;
    private javax.swing.JButton refreshLocationTable;
    private javax.swing.JButton refreshPassengerTable;
    private javax.swing.JButton refreshPlanesTable;
    private javax.swing.JTable showAllFlightsTable;
    private javax.swing.JComboBox<String> textDayDepartureDate_RegFlight;
    private javax.swing.JComboBox<String> textHourDepartureDate_RegFlight;
    private javax.swing.JComboBox<String> textMonthDepartureDate_RegFlight;
    private javax.swing.JTextField textYearDepartureDate_RegFlight;
    private javax.swing.JTextField txtAirportCity;
    private javax.swing.JTextField txtAirportCountry;
    private javax.swing.JTextField txtAirportID;
    private javax.swing.JTextField txtAirportLatitude;
    private javax.swing.JTextField txtAirportLongitude;
    private javax.swing.JTextField txtAirportName;
    private javax.swing.JComboBox<String> txtFlights_addPassengerToFlight;
    private javax.swing.JComboBox<String> txtFlights_delayFlights;
    private javax.swing.JComboBox<String> txtHourDuration_RegFlight;
    private javax.swing.JComboBox<String> txtHourScaleDuration_RegFlight;
    private javax.swing.JComboBox<String> txtMinsDuration_RegFlight;
    private javax.swing.JComboBox<String> txtMinsScaleDuration_RegFlight;
    private javax.swing.JTextField txtPIaneID;
    private javax.swing.JTextField txtPassengerId;
    private javax.swing.JTextField txtPassengerRegCountry;
    private javax.swing.JTextField txtPassengerRegFirstName;
    private javax.swing.JTextField txtPassengerRegLastName;
    private javax.swing.JTextField txtPassengerRegPhone;
    private javax.swing.JTextField txtPassengerRegPhoneCode;
    private javax.swing.JTextField txtPassengerRegYear;
    private javax.swing.JTextField txtPlaneAirline;
    private javax.swing.JTextField txtPlaneBrand;
    private javax.swing.JTextField txtPlaneMaxCapacity;
    private javax.swing.JTextField txtPlaneModel;
    private javax.swing.JTextField txtRegPassengerID;
    private javax.swing.JTextField txtUpdCountry;
    private javax.swing.JTextField txtUpdFirstName;
    private javax.swing.JTextField txtUpdID;
    private javax.swing.JTextField txtUpdLastName;
    private javax.swing.JTextField txtUpdPhone;
    private javax.swing.JTextField txtUpdPhoneCode;
    private javax.swing.JTextField txtUpdYear;
    private javax.swing.JButton updatePassengerButton;
    private javax.swing.JRadioButton user;
    private javax.swing.JComboBox<String> userSelect;
    // End of variables declaration//GEN-END:variables
}
