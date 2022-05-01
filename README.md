
<h1>À FAIRE</h1>
<h3>ENLEVER TOUT CE QUI EST EN RAPPORT AVEC LA LIVRAISON </h3>
<h2>GLOBAL</h2>

* Refaire le rendu graphique du logiciel
* Ajout d'une icône
* Permettre un enregistrement des données à travers les sessions
* Modification du nom / MDP d'un magasin


<h2>MODEL</h2>

<b>Client</b> :
* Finaliser l'implémentation de la date de naissance dans NewClient/NewEmploye

<b>Magasin</b> : 
* Ajout d'autres arguments facultatifs (Mot de passe/Site web/téléphone/Nom du directeur/date de création/logo?)

<h2>CONTROLLER</h2>

* (basse priorité) Trouver un moyen de fusionner les méthodes à mêmes fonctions pour différentes fenêtres (exemple : NewClient et NewClient_gest)
* prendre une date valide JTextfiel de la date => taille 4 + date => comprise entre 1910-2010
* modifier l'affichage du téléphone |FRA|+33|nombre de taille 9|
* afficher les messages d'erreur lorsque l'on crée un livre/client/employé
* afficher un message d'erreur lorsque l'on souhaite supprimer un achat/employé/client/livre "Etes-vous sûre de vouloir supprimer cet ...?"

<h2>VIEW</h2>

<b>Statistiques </b> : 

* Ajouter un système de recherche + filtre (partout sauf compta)
* prendre en compte les dépenses dans la partie compta

<b>DoAch </b> : 

* afficher le prix de chacun des articles ajoutés 
* si on sélectionne plusieurs fois le même article n'afficher qu'un seul article avec x2 (par exemple) sinon x1
* afficher le prix total courant
* Permettre de pouvoir afficher les infos d'un livre en double-cliquant sur un élément de la liste de livre 

<b>Gest_Achats </b> : 

* Afficher les articles de l'achat dans la partie à droite

<b>Gest_Livre/Client/Employé </b> : 

* Afficher les articles de l'achat dans la partie à droite
* Bloquer l'accès à la modification du JTextfield id ou créer un JLabel
* 
