# Gretel Finding Hansel :couple:
Shortest Path in a Maze Algorithm using backtracking between randomly generated source(Greta) and destination(Hansel).
## Description
Hansel is lost in a :deciduous_tree: forest :deciduous_tree: and Gretel have to find him :eyes:. All the forest/maze walls are represented with '#'. The only way out to the forest is if Gretel can find her brother Hansel, only then they can together teleport out of the forest ⚡ :milky_way: ⚡.

## Input and Output
An input file is provided with the number of rows and columns in the first line, followed by the maze in following lines. Hansel and Gretel are randomly placed in the maze within the bounds of the maze and if the set coordinate is not a wall/tree('#').
#### :point_down: My [algortihm](https://github.com/armitage420/finding-hansel/blob/main/Shortest%20Path/src/com/maze/Grid.java) gave the following results to the input files :point_down:
#### Below is the maze provided in the [First file](https://github.com/armitage420/finding-hansel/blob/main/Shortest%20Path/mz1.txt):
```
###########
#         #
#### ######
#    #    #
#    #    #
# ###### ##
#         #
###########
```
#### After running my algorithm, an [Output file](https://github.com/armitage420/finding-hansel/blob/main/Shortest%20Path/opmz1.txt) was generated with this output(also console output):
```
###########
#         #
####G######
# v<v#  H<#
#v<^<#  >^#
#v######^##
#>>>>>>>^ #
###########
```

#### And the maze for [Second file](https://github.com/armitage420/finding-hansel/blob/main/Shortest%20Path/mz2.txt) is:
```
###################################################################################################
#   #                                                                                             #
#   #  #####  ###########  #########################################   #######################    #
#    #  #   #  #       #         #         ######################                             #   #
#    #  #   #  ####    #         #               ###########################################  #   #
#    #  #   #     #    #         #               ####                                      #  #   #
#    #  #   #     #    #               ####                 ############################   #  #   #
#    ###########  #    #         #################          #                              #  #   #
#                 #  #########################################   ##############################   #
###################                                              #                                #
########################################################### ######              ###################
#                                                           ######                                #
####################################   ###########################                                #
##########       #######           #                          #####################################
#                                  #                 ######                                       #
#         #####################                        ####                     ############# #####
#                #####             #                    ##########################                #
#    ########################################################################                     #
#                                  #                   #                                          #
#                                  #                   #                                          #
##########################         #                   #       ####################################
#                        #         #                   #                                          #
#                        #         ################    #                                          #
#                        #####     #                   #                                          #
#                            #     #     #########     #                                          #
#                            #     #        #####      #############################              #
#                            #     #         ####                                                 #
#                            #     #         ######  #######################  ##################  #
#                                  #############                           #  ##################  #
###########################  #######                                       #                      #
#                         #  #     #################################       ########################
#                         #  #     #         #  #  #    #   #      #                              #
#                         #  #     #            #  #  # #          ##           #                 #
#                         #  #     ###########  #  #  # #   #       #           #                 #
#                         #  #     #         #  #  #  # #   #       #    #############            #
#                         #  #     #            #  #  # #   #       #          #####              #
#                         #  #     ######### #  #  #  # #   #       #            #                #
#                         #  #     #         #  #  #  # #   #       #            #                #
#                         #  #     #  ########  #  #  # #   #       #            #                #
#                         #  #     #         #  #  #  # #   #       #            #                #
#                         #  #     ########  #  # ##  # #   #       #            #                #
#                            #     #         #  # #  ## ##  #       #            #                #
######################### ##########  ########  ###   #  #  #                    #                #
#                  #      ####     #   #     #        #  #  #                    #                #
#                  #               #   #    ###########  #  #                    #                #
#                  #               #   #            #    ## #                    #                #
#                  #               #                # ##### #                    #                #
#                  #   #########   #   #            #       #                    #                #
#                  #       #       #   #            ###############################################
#                  #       #       ###############            ################################### #
#                  #       #       #             #                                ########        #
#                  #                             #       #######################  ########        #
#                  #       ##################################                                     #
###################################################################################################
```
#### And it's [Output file](https://github.com/armitage420/finding-hansel/blob/main/Shortest%20Path/opmz2.txt)/console output was:
```
###################################################################################################
#G  #                                                                                             #
#v  #  #####  ###########  #########################################   #######################    #
#v   #  #   #  #       #         #         ######################                             #   #
#v   #  #   #  ####    #         #               ###########################################  #   #
#v   #  #   #     #    #         #               ####                                      #  #   #
#v   #  #   #     #    #               ####                 ############################   #  #   #
#v   ########### H#    #         #################          #                              #  #   #
#>>>>>>>>>>>>>>>>^#  #########################################   ##############################   #
###################                                              #                                #
########################################################### ######              ###################
#                                                           ######                                #
####################################   ###########################                                #
##########       #######           #                          #####################################
#                                  #                 ######                                       #
#         #####################                        ####                     ############# #####
#                #####             #                    ##########################                #
#    ########################################################################                     #
#                                  #                   #                                          #
#                                  #                   #                                          #
##########################         #                   #       ####################################
#                        #         #                   #                                          #
#                        #         ################    #                                          #
#                        #####     #                   #                                          #
#                            #     #     #########     #                                          #
#                            #     #        #####      #############################              #
#                            #     #         ####                                                 #
#                            #     #         ######  #######################  ##################  #
#                                  #############                           #  ##################  #
###########################  #######                                       #                      #
#                         #  #     #################################       ########################
#                         #  #     #         #  #  #    #   #      #                              #
#                         #  #     #            #  #  # #          ##           #                 #
#                         #  #     ###########  #  #  # #   #       #           #                 #
#                         #  #     #         #  #  #  # #   #       #    #############            #
#                         #  #     #            #  #  # #   #       #          #####              #
#                         #  #     ######### #  #  #  # #   #       #            #                #
#                         #  #     #         #  #  #  # #   #       #            #                #
#                         #  #     #  ########  #  #  # #   #       #            #                #
#                         #  #     #         #  #  #  # #   #       #            #                #
#                         #  #     ########  #  # ##  # #   #       #            #                #
#                            #     #         #  # #  ## ##  #       #            #                #
######################### ##########  ########  ###   #  #  #                    #                #
#                  #      ####     #   #     #        #  #  #                    #                #
#                  #               #   #    ###########  #  #                    #                #
#                  #               #   #            #    ## #                    #                #
#                  #               #                # ##### #                    #                #
#                  #   #########   #   #            #       #                    #                #
#                  #       #       #   #            ###############################################
#                  #       #       ###############            ################################### #
#                  #       #       #             #                                ########        #
#                  #                             #       #######################  ########        #
#                  #       ##################################                                     #
###################################################################################################
```

##### N.B.- Every time different outputs will be printed as the positions of Hansel and Gretal are generated randomly(valid positions only). No position out of the bound of the maze or any position having maze wall will not be generated.
