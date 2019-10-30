  /**
     * 使用递归方法建树
     * @param treeNodes
     * @return
     */
    public  List<NetTopologyVo> buildByRecursive( List<NetTopologyVo> treeNodes) {
        List<NetTopologyVo> trees = new ArrayList<NetTopologyVo>();
        for (NetTopologyVo treeNode : treeNodes) {
            if ("0".equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode,treeNodes));
            }
        }
        return trees;
    }
 
    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    public static NetTopologyVo findChildren(NetTopologyVo treeNode,List<NetTopologyVo> treeNodes) {
        treeNode.setChildren(new ArrayList<NetTopologyVo>());
 
        for (NetTopologyVo it : treeNodes) {
            if(treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<NetTopologyVo>());
                }
                treeNode.getChildren().add(findChildren(it,treeNodes));
            }
        }
        treeNode.setNum(treeNode.getChildren().size());
        return treeNode;
    }
