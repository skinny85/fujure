package org.fujure.truffle.nodes

import org.fujure.fbc.ast.Module

class ModuleNonRootNode(val module: Module, val defs: List<DefNode>)
