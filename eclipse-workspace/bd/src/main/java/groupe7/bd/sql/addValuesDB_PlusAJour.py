#Configuration:
from pyexpat import model


nbStation = 5
borneStation = 10
nbVeloStation = 5 #[3] manuelle [2] electrique

#Base
nomRue = ['alpha','beta','gamma','delta','epsilon','zeta','eta','theta','iota'
            ,'kappa','lambda','mu','nu']





#Auteur
dataAuteur = []
dataAuteur.append("/*Table Auteur*/\n");
dataAuteur.append("INSERT INTO Auteur (nom,prenom)\n");
dataAuteur.append("\tVALUES\n");
dataAuteur.append("\t('BOUCHELOUCHE','Mahrez'),\n");
dataAuteur.append("\t('CHOLVY','Jordan'),\n");
dataAuteur.append("\t('DIALLO','Thierno'),\n");
dataAuteur.append("\t('DUONG','Tien-Khoi'),\n");
dataAuteur.append("\t('MARTINS','Yohan');\n");

#Station
dataStation = []
dataStation.append("/*Table Station*/\n");
dataStation.append("INSERT INTO Station (idStation,adresse,statu)\n");
dataStation.append("\tVALUES\n");
for i in range (0,nbStation):
    dataStation.append("\t("+str(i+1)+",'"+str(i+1)+" rue "+nomRue[i]+"','vnul'),\n");
dataStation[-1] = ("\t("+str(i+1)+",'"+str(i+1)+" rue "+nomRue[i]+"','vnul');\n");

#Bornette
dataBornette = []
dataBornette.append("/*Table Bornette*/\n");
dataBornette.append("INSERT INTO Bornette (idBornette,idStations,status)\n");
dataBornette.append("\tVALUES\n");
for i in range(0,nbStation):
    for j in range(0,borneStation):
        dataBornette.append("\t("+str((i+1)*100+j+1)+","+str(i+1)+",'ok'),\n");

dataBornette[-1] = ("\t("+str((i+1)*100+j+1)+","+str(i+1)+",'ok');\n");

#Velo
dataVelo = []
dataVelo.append("/*Table Velo*/\n");
dataVelo.append("INSERT INTO Velo (idVelo,idBorne,modelVelo,etatVelo,dateMenS)\n");
dataVelo.append("\tVALUES\n");
for i in range(0,nbStation):
    for j in range(0,borneStation):
        #id
        idVelo = str(i*nbStation + j + 1)
        #Modelle
        if ( (int(idVelo)%5) < 3):
            modelVelo = "'manuel'"
        else:    
            modelVelo = "'electrique'"
        #Etat
        if ( (int(idVelo)%4) == 0):
            etatVelo = "'hs'"
            idBornette = "null"
        else:
            etatVelo = "'ok'"
            idBornette = str((i+1)*100+j+1)

        dataVelo.append("\t("+idVelo+","+idBornette+","+modelVelo+","+etatVelo+",'22-01-0"+str(int(idVelo)%5+1)+"'),\n");

dataVelo[-1] = ("\t("+idVelo+","+str((i+1)*100+j+1)+","+modelVelo+","+etatVelo+",'22-01-0"+str(int(idVelo)%5+1)+"');\n");

#Location
dataLocation = []
dataLocation.append("/*Table Location*/\n");
dataLocation.append("INSERT INTO Location (idVelo,idBornette,modelVelo,etatVelo,dateMenS)\n");
dataLocation.append("\tVALUES\n");


#Donnee a ecrire
data = []
data.extend(dataAuteur);
data.append("\n")
data.extend(dataStation);
data.append("\n")
data.extend(dataBornette);
data.append("\n")
data.extend(dataVelo);
data.append("\n")
data.extend(dataLocation);
#Creation du fichier sql
fichier = open("addValuesDB_old.sql", "w")
for line in data:
    fichier.write(line)
fichier.close()
